package pages;

import static com.codeborne.selenide.Condition.selected;

public class PostsListPage extends MainPage {

    public PostsListPage postsTabShouldBeSelected() {
        postsTab.shouldBe(selected);

        return this;
    }

    public PostsListPage usersTabShouldNotBeSelected() {
        usersTab.shouldNotBe(selected);

        return this;
    }
}
