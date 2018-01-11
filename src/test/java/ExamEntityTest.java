import com.tiantianchiji.onlineexam.entities.ExamEntity;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ExamEntityTest {
    @Test
    public void verifySetName() throws Exception {
        final String expeted = "aa";
        ExamEntity entity = new ExamEntity();

        entity.setName(expeted);

        final String actual = entity.getName();

        assertEquals(expeted, actual);

    }

    @Test
    public void verifySetDescription() throws Exception {
        final String expected = "aa";
        ExamEntity entity = new ExamEntity();

        entity.setDescription(expected);

        final String actual = entity.getDescription();

        assertEquals(expected, actual);
    }
}
