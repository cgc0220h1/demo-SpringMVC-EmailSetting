package controllers;

import model.Setting;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Duc on 6/2/2020
 * @project demo-SpringMVC-EmailSetting
 **/

@Controller
@RequestMapping("/")
public class SettingController {

    @ModelAttribute("setting")
    public Setting setting() {
        return new Setting();
    }

    @GetMapping()
    public ModelAndView showSettingPage() {
        ModelAndView modelAndView = new ModelAndView("setting");
        modelAndView.addObject("setting", new Setting());
        return modelAndView;
    }

    @PostMapping()
    public ModelAndView updateSetting(@ModelAttribute("setting") Setting setting) {
        ModelAndView modelAndView = new ModelAndView("setting");
        modelAndView.addObject("setting", setting);
        modelAndView.addObject("message", "Setting saved");
        return new ModelAndView("setting", "setting", setting);
    }
}
