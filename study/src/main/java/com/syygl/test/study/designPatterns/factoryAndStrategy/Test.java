package com.syygl.test.study.designPatterns.factoryAndStrategy;

/**
 * Created by sunyy on 2020/1/27.
 */
public class Test {
    private static double getResult(long money, int type) {
        double result = money;
        if (money >= 1000) {
            if (type == 1) {
                result = new SilverStrategy().compute(money);
            } else {
                result = new OrdinaryStrategy().compute(money);
            }
        }
        return result;
    }

    //第一次优化
    //我们在这里把 money < 1000 的情况提前 return。更关注于满1000逻辑 ,也可以减少不必要的缩进。
    private static double getResult2(long money, int type) {
        if (money < 1000) {
            return money;
        }
        Strategy strategyInterface;

        if (type == 1) {
            strategyInterface = new SilverStrategy();
        } else {
            strategyInterface = new OrdinaryStrategy();
        }
        return strategyInterface.compute(money);
    }

    //最终优化
    private static double getResult3(long money, int type) {

        if (money < 1000) {
            return money;
        }

        Strategy strategyInterface = StrategyFactory.getInstance().get(type);

        if (strategyInterface == null) {
            throw new IllegalArgumentException("please input right type");
        }

        return strategyInterface.compute(money);
    }
}
