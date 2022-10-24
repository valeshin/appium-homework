package pages;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.*;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public abstract class MainPage<T> extends BasePage<MainPage> {

    protected final SelenideElement usersTab = $(new ByAccessibilityId("Пользователи\nTab 1 of 2"));
    protected final SelenideElement postsTab = $(new ByAccessibilityId("Посты\nTab 2 of 2"));

    public T open() {
        Selenide.open();

        return (T) this;
    }

    public UsersListPage openUsersList() {
        usersTab.click();

        return new UsersListPage();
    }

    public PostsListPage openPostsList() {
        postsTab.click();

        return new PostsListPage();
    }

}
