package com.rest.back.websocket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebsocketController {

	@GetMapping("/websocketPage")
	public String websocketView() {
		System.out.println("goPage websocketPage");
			
		return "websocketPage";
	}
}
