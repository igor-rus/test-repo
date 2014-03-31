package ee.city24.sampleapp.web.pages;

import ee.city24.sampleapp.entity.User;
import ee.city24.sampleapp.service.UserService;
import ee.city24.sampleapp.web.forms.AddUserForm;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.markup.repeater.data.ListDataProvider;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage {

    @SpringBean
    static UserService userService;

    private static final long serialVersionUID = 1L;

    public HomePage() {

        add(new AddUserForm("user_add"));

        IDataProvider<User> provider = newDataProvider();
        List<IColumn<User>> columns = newColumnList();

        DataTable<User> table = new DataTable<User>("datatable", columns, provider, 30);
        this.add(table);

    }

    private static IDataProvider<User> newDataProvider() {
        return new ListDataProvider<User>(userService.getAllUsers());
    }

    private static List<IColumn<User>> newColumnList() {

        List<IColumn<User>> columns = new ArrayList<IColumn<User>>();

        columns.add(new PropertyColumn<User>(Model.of("firstName"), "firstName"));
        columns.add(new PropertyColumn<User>(Model.of("lastName"), "lastName"));
        columns.add(new PropertyColumn<User>(Model.of("createdOn"), "createdOn"));

        return columns;
    }

}
