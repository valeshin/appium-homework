import extentions.AppiumExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.UsersListPage;

@ExtendWith(AppiumExtension.class)
public class UsersTest {

    private UsersListPage usersListPage = new UsersListPage();

    @Test
    public void testFirst() {
        usersListPage.open()
                .usersTabShouldBeSelected()
                .postsTabShouldNotBeSelected()
                .openPostsList()
                .postsTabShouldBeSelected()
                .usersTabShouldNotBeSelected();

    }
}
