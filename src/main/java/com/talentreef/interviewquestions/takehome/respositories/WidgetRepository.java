package com.talentreef.interviewquestions.takehome.respositories;

import com.talentreef.interviewquestions.takehome.models.Widget;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class WidgetRepository {

    // List of widgets
    private List<Widget> table = new ArrayList<>();

    // DELETE widget by ID
    public List<Widget> deleteById(String name) {
        this.table = table.stream()
                .filter((Widget widget) -> !name.equals(widget.getName()))
                .collect(Collectors.toCollection(ArrayList::new));
        return table;
    }
    // We could add another delete widget by id that returns T/F

    // List of all widgets
    public List<Widget> findAll() {
        return table;
    }

    // Search by widget ID
    public Optional<Widget> findById(String name) {
        Optional<Widget> result = table.stream()
                .filter((Widget widget) -> name.equals(widget.getName()))
                .findAny();
        return result;
    }

    // Save widget to table List, avoids duplicates by deleting through same name
    // can work as an Update by using the same ID, it will replace desc and price with the new values
    public Widget save(Widget widget) {
        deleteById(widget.getName());
        table.add(widget);
        return widget;
    }

    // Create Widget - Automatically add to list
    public Widget create(String aName, String aDescription, double aPrice) {
        Widget widget = Widget.builder()
                .name(aName)
                .description(aDescription)
                .price(aPrice)
                .build();
        save(widget);
        return widget;
    }

    // Retrieve description by name - Returns description or null if ID not found
    public String retrieveDesc(String aName) {
        Optional<Widget> optionalWidget = findById(aName);
        return optionalWidget.map(Widget::getDescription).orElse(null);
        /*
        if (optionalWidget.isPresent()) {
            return optionalWidget.get().getDescription();
        } else {
            return null;
        }
         */
    }

    // Retrieve price by name - Returns price or 0 if ID not found
    public double retrievePrice(String aName) {
        Optional<Widget> optionalWidget = findById(aName);
        return optionalWidget.map(Widget::getPrice).orElse(0.0);
        /*
         if (optionalWidget.isPresent()) {
            return optionalWidget.get().getPrice();
        } else {
            return 0;
        }
         */
    }

    // UPDATE description of widget found by name - updates the list after the changes
    public Widget updateDesc(String aName, String aDescription) {
        Optional<Widget> optionalWidget = findById(aName);
        if (optionalWidget.isPresent()) {
            Widget widget = optionalWidget.get();
            widget.setDescription(aDescription);
            return widget;
        } else {
            return null;
        }
    }

    // UPDATE price of widget found by name - updates the list after the changes
    public Widget updatePrice(String aName, double aPrice) {
        Optional<Widget> optionalWidget = findById(aName);
        if (optionalWidget.isPresent()) {
            Widget widget = optionalWidget.get();
            widget.setPrice(aPrice);
            return widget;
        } else {
            return null;
        }
    }
}
