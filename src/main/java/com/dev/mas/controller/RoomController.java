package com.dev.mas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dev.mas.exception.SequenceException;

import com.dev.mas.model.M0_TbRoom;

import com.dev.mas.service.M0_TbRoomService;

@Controller
@RequestMapping(value = "/room")
public class RoomController {
	
	@Autowired
	private ApplicationContext ctx;

	@Autowired
	private M0_TbRoomService m0_tbroomService;

	private M0_TbRoom m0_tbroom = new M0_TbRoom();
	private List<M0_TbRoom> m0_tbroomList = null;
	private Query query = new Query();

	@RequestMapping(value = { "", "/list" }, method = RequestMethod.GET)
	public String defaultPage(ModelMap modelmap) {
		// clear form
		modelmap.addAttribute("dataM0_TbRoom", new M0_TbRoom());
		// try {
		// List<Hosting> hostingList = hostingService.list();
		// query.with(new Sort(Sort.Direction.DESC, "id"));
		// List<Hosting> hostingList = hostingService.findByCriteria(query);
		List<M0_TbRoom> m0_tbroomList = getDefaultList();
		modelmap.addAttribute("retRoomList", m0_tbroomList);
		modelmap.addAttribute("retRoom", "---");
		// } catch (SequenceException e) {
		// modelmap.addAttribute("retSamples", e.getErrMsg());
		// } finally {
		//
		// }

		return "room";

	}

	@RequestMapping(value = { "/upsert/{id}" }, method = RequestMethod.GET)
	public String processUpsertGet(ModelMap modelmap, @PathVariable int id) {
		try {
			// show form
			m0_tbroom = m0_tbroomService.listById(id);
			modelmap.addAttribute("dataM0_TbRoom", m0_tbroom);

			// all list
			List<M0_TbRoom> m0_tbroomList = getDefaultList();
			modelmap.addAttribute("retRoomList", m0_tbroomList);
			modelmap.addAttribute("retRoom", "---");
		} catch (SequenceException e) {
			modelmap.addAttribute("retRoom", e.getErrMsg());
		} finally {

		}

		return "room";
	}

	@RequestMapping(value = { "/upsert" }, params = { "cmdName" }, method = RequestMethod.POST)
	public String processUpsertPost(ModelMap modelmap,
			@RequestParam String cmdName, M0_TbRoom m0_tbroom) {
		if (cmdName.equals("save")) {
			try {
				m0_tbroomService.save(m0_tbroom);
			} catch (SequenceException e) {
				modelmap.addAttribute("retRoom", e.getErrMsg());
			} finally {
				modelmap.addAttribute("dataM0_TbRoom", new M0_TbRoom());
			}
		} else if (cmdName.equals("cancel")) {
			modelmap.addAttribute("dataM0_TbRoom", new M0_TbRoom());
		}

		return "redirect:/room/";
	}

	private List<M0_TbRoom> getDefaultList() {
		try {
			query.with(new Sort(Sort.Direction.DESC, "id"));
			m0_tbroomList = m0_tbroomService.findByCriteria(query);
		} catch (SequenceException e) {

		} finally {

		}

		return m0_tbroomList;
	}


}
