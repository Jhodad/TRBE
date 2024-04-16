package com.talentreef.interviewquestions.takehome.controllers;

import com.talentreef.interviewquestions.takehome.models.Widget;
import com.talentreef.interviewquestions.takehome.services.WidgetService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping(value = "/v1/widgets", produces = MediaType.APPLICATION_JSON_VALUE)
public class WidgetController {

    private final WidgetService widgetService;

    @Autowired
    public WidgetController(WidgetService widgetService) {
        Assert.notNull(widgetService, "widgetService must not be null");
        this.widgetService = widgetService;
    }

    /*
    [{
        "name": "Clock",
        "description": "Basic clock display",
        "price": 5.99
    },
    {
        "name": "Weather",
        "description": "Displays the current weather for your location",
        "price": 25.20
    },
    {
        "name": "News",
        "description": "Get the latest news!",
        "price": 25.20
    }]
     */

    // POST http://localhost:9000/v1/widgets
    @PostMapping
    public ResponseEntity<List<Widget>> createWidgets(@Valid @RequestBody List<Widget> widgets) {
        widgetService.createWidgets(widgets);
        return ResponseEntity.ok(widgets);
    }

    // GET http://localhost:9000/v1/widgets
    @GetMapping
    public ResponseEntity<List<Widget>> getAllWidgets() {
        return ResponseEntity.ok(widgetService.getAllWidgets());
    }

    // GET http://localhost:9000/v1/widgets/WidgetName
    @GetMapping("/{name}")
    public ResponseEntity<Optional<Widget>> getWidgetByName(@PathVariable String name) {
        Optional<Widget> widget = widgetService.getWidgetById(name);
        return ResponseEntity.ok(widget);
    }

    // GET http://localhost:9000/v1/widgets/{name}/description - retrieve the description of a widget by name
    @GetMapping("/{name}/description")
    public ResponseEntity<String> getWidgetDescription(@PathVariable String name) {
        String description = widgetService.getWidgetDescription(name);
        return ResponseEntity.ok(description);
    }

    // GET http://localhost:9000/v1/widgets/{name}/price - retrieve the price of a widget by name
    @GetMapping("/{name}/price")
    public ResponseEntity<Double> getWidgetPrice(@PathVariable String name) {
        double price = widgetService.getWidgetPrice(name);
        return ResponseEntity.ok(price);
    }

    // DELETE http://localhost:9000/v1/widgets/{name}
    @DeleteMapping("/{name}")
    public ResponseEntity<Void> deleteWidget(@PathVariable String name) {
        widgetService.deleteWidget(name);
        return ResponseEntity.noContent().build();
    }

    // Updates can be forced by adding a new Widget with the same name but new values
    // PUT http://localhost:9000/v1/widgets/{name}/description
    // Raw body: A new description
    @PutMapping("/{name}/description")
    public ResponseEntity<Widget> updateWidgetDescription(@PathVariable String name, @RequestBody String newDescription) {
        Widget widget =  widgetService.updateWidgetDescription(name, newDescription);
        return ResponseEntity.ok(widget);
    }

    // PUT http://localhost:9000/v1/widgets/{name}/price
    // Raw body: A new price
    @PutMapping("/{name}/price")
    public ResponseEntity<Widget> updateWidgetPrice(@PathVariable String name, @RequestBody Double newPrice) {
        Widget widget =  widgetService.updateWidgetPrice(name, newPrice);
        return ResponseEntity.ok(widget);
    }

}
