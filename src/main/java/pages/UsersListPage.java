package pages;

import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class UsersListPage extends MainPage<UsersListPage> {

    public UsersListPage usersTabShouldBeSelected() {
//        usersTab.shouldBe(visible);
        usersTab.exists();
//        $(new AppiumBy.ByAccessibilityId("Пользователи\n Tab 1 of 2"));

        return this;
    }

    public UsersListPage postsTabShouldNotBeSelected() {
        postsTab.shouldNotBe(selected);

        return this;
    }
}
