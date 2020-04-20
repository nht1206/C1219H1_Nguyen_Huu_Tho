package controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Date;
import java.util.TimeZone;
@Controller
public class TimeController {
    @RequestMapping("worldclock")
    public String getTimeByTimezone(ModelMap model, @RequestParam(name = "city",
            required = false, defaultValue = "Asia/Ho_Chi_Minh") String city) {
        Date date = new Date();
        TimeZone local = TimeZone.getDefault();
        TimeZone locale = TimeZone.getTimeZone(city);
        // Calculate the current time in the specified city
        long locale_time = date.getTime() +
                (locale.getRawOffset() - local.getRawOffset());
        // Reset the date by locale_time
        date.setTime(locale_time);
        model.addAttribute("city", city);
        model.addAttribute("date", date);
        return "worldclock";
    }
}