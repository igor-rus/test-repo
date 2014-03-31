package ee.city24.sampleapp.web.forms;

import ee.city24.sampleapp.entity.User;
import ee.city24.sampleapp.service.UserService;
import ee.city24.sampleapp.web.pages.HomePage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Igor
 * Date: 25.09.13
 * Time: 0:03
 * To change this template use File | Settings | File Templates.
 */
public class AddUserForm extends Form<User> {

    @SpringBean
    UserService userService;

    public AddUserForm(String id) {

        super(id, new CompoundPropertyModel<User>(new User()));

        add(new TextField("userName"));
        add(new TextField("firstName"));
        add(new TextField("lastName"));
        add(new TextField("password"));

    }

    @Override
    public void onSubmit() {
        User user = (User) this.getModelObject();
        user.setCreatedOn(new Date());
        userService.saveUser(user);
        setResponsePage(HomePage.class);

    }

}
