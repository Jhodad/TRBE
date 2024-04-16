package com.talentreef.interviewquestions.takehome.services;

import com.talentreef.interviewquestions.takehome.models.Widget;
import com.talentreef.interviewquestions.takehome.respositories.WidgetRepository;
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
    public void createWidgets(List<Widget> widgets) {
        for (Widget widget : widgets) {
            widgetRepository.create(widget.getName(), widget.getDescription(), widget.getPrice());
        }
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
