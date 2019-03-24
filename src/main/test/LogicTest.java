import com.denisqq.Logic;
import com.denisqq.functions.LTrapezoid;
import com.denisqq.functions.RTrapezoid;
import com.denisqq.functions.Triangle;
import com.denisqq.rule.Conclusion;
import com.denisqq.rule.Condition;
import com.denisqq.rule.Rule;
import com.denisqq.rule.Variable;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LogicTest {
    @Test
    public void logicTest() {

        List<Double> values = Arrays.asList(0.00001D);

        Triangle onFoot = new Triangle(0.0D, 7.0D, 3.0D);
        Triangle onCar = new Triangle(4.0D, 15.0D, 8.0D);

        LTrapezoid big = new LTrapezoid(4.0D, 8.0D);
        RTrapezoid small = new RTrapezoid(0.0D, 5.0D);


        List<Rule> rules = new ArrayList<>();

        Rule r1 = new Rule();
        r1.setConditionList(Arrays.asList(
                new Condition(big, "Большая", new Variable(0)),
                new Condition(big, "Большая", new Variable(1))
        ));
        r1.setConclusion(
                new Conclusion(onCar, "На машине", new Variable(0), 1.0D)
        );
        rules.add(r1);

        Rule r2 = new Rule();
        r2.setConditionList(Arrays.asList(
                new Condition(small, "Маленькая", new Variable(0)),
                new Condition(small, "Маленькая", new Variable(1))
        ));
        r2.setConclusion(
                new Conclusion(onFoot, "Пешком", new Variable(0), 1.0D)
        );
        rules.add(r2);

        Rule r3 = new Rule();
        r3.setConditionList(Arrays.asList(
                new Condition(big, "Большая", new Variable(0)),
                new Condition(small, "Маленькая", new Variable(1))
        ));
        r3.setConclusion(
                new Conclusion(onFoot, "Бол->Мал", new Variable(0), 0.5D)
        );
        rules.add(r3);

        Rule r4 = new Rule();
        r4.setConditionList(Arrays.asList(
                new Condition(small, "Маленькая", new Variable(0)),
                new Condition(big, "Большая", new Variable(1))
        ));
        r4.setConclusion(
                new Conclusion(onCar, "Мал->Бол", new Variable(0), 0.5D)
        );
        rules.add(r3);


        Logic logic = new Logic(rules);

        System.out.println("result: " + logic.calc(values));

    }
}
