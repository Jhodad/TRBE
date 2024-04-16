package com.talentreef.interviewquestions.takehome.services;

import com.talentreef.interviewquestions.takehome.models.Widget;
import com.talentreef.interviewquestions.takehome.respositories.WidgetRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class WidgetService {

    private final WidgetRepository widgetRepository;

    @Autowired
    private WidgetService(WidgetRepository widgetRepository) {
        Assert.notNull(widgetRepository, "widgetRepository must not be null");
        this.widgetRepository = widgetRepository;
    }

    // CREATE widgets POST as a list of a single or multiple widgets
//    public void createWidgets(@Valid List<Widget> widgets) {
//        for (Widget widget : widgets) {
//            widgetRepository.create(widget.getName(), widget.getDescription(), widget.getPrice());
//        }
//    }

    public void createWidgets(List<Widget> widgets) {
        for (Widget widget : widgets) {
            validateWidget(widget);
            widgetRepository.create(widget.getName(), widget.getDescription(), widget.getPrice());
        }
    }

    private void validateWidget(Widget widget) {
        Assert.isTrue(widget.getPrice() <= 20000.00, "Price must be less than or equal to 20000.00");
        Assert.isTrue(widget.getPrice() >= 1.00, "Price must be greater than or equal to 1.00");
        Assert.isTrue(String.format("%.2f", widget.getPrice()).length() <= 5, "Price must have at most 2 decimal places");
        Assert.isTrue(widget.getName().length() >= 3, "Name must be at least 3 characters long");
        Assert.isTrue(widget.getName().length() <= 100, "Name must be at most 100 characters long");
        Assert.isTrue(widget.getDescription().length() >= 5, "Description must be at least 5 characters long");
        Assert.isTrue(widget.getDescription().length() <= 1000, "Description must be at most 1000 characters long");
    }

    // GET the list of widgets
    public List<Widget> getAllWidgets() {
        return widgetRepository.findAll();
    }

    // GET a widget given its name - can return empty
    public Optional<Widget> getWidgetById(String name) {
        return widgetRepository.findById(name);
    }

    // GET description of a Widget given its name
    public String getWidgetDescription(String name) {
        return widgetRepository.retrieveDesc(name);
    }

    // GET price of a Widget given its name
    public double getWidgetPrice(String name) {
        return widgetRepository.retrievePrice(name);
    }

    // DELETE a Widget given its name
    // returns true if deleted
    public void deleteWidget(String name) {
        widgetRepository.deleteById(name);
    }

    // (PUT) UPDATE a widget's description given a name, and it's new description
    public Widget updateWidgetDescription(String name, String newDescription) {
        return widgetRepository.updateDesc(name, newDescription);
    }

    // (PUT) UPDATE a widget's price given a name, and it's new price
    public Widget updateWidgetPrice(String name, double newPrice) {
        return widgetRepository.updatePrice(name, newPrice);
    }

}
