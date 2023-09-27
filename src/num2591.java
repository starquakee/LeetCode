import java.util.*;
public class num2591 {
    public int distMoney(int money, int children) {
        if(money<children)return -1;
        if(money<children+7)return 0;
        int num = Math.min((money-children)/7,children);
        int remain = money-children-7*num;
        if(remain==3&&children-num==1)return num-1;
        if(remain>0&&num==children)return num-1;
        return num;
    }
}
