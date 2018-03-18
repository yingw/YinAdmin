package cn.yinguowei.admin;

import cn.yinguowei.admin.mock.Profile;
import com.sun.org.apache.bcel.internal.generic.NEW;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @author yinguowei@gmail.com 2018/3/16.
 */
@RestController
public class DashboardController {
    // 数据

    private static final List<Rule> rules = new ArrayList<>();
    private static Random random = new Random();

    static {
        for (int i = 0; i < 46; i += 1) {

            rules.add(new Rule(
                    i,
                    ((i % 6) == 0),
                    "https://ant.design",
                    "https://gw.alipayobjects.com/zos/rmsportal/eeHMaZBwmTvLdIwMfBpg.png",
                    "TradeCode " + i,
                    "一个任务名称 " + i,
                    "曲丽丽",
                    "这是一段描述",
                    Math.floor(Math.random() * 1000),
                    Math.floor(Math.random() * 10) % 4,
                    new Date(),
                    new Date(),
                    Math.ceil(Math.random() * 100)
            ));
        }
    }

    String[] titles = {
            "Alipay",
            "Angular",
            "Ant Design",
            "Ant Design Pro",
            "Bootstrap",
            "React",
            "Vue",
            "Webpack"};
    String[] avatars = {
            "https://gw.alipayobjects.com/zos/rmsportal/WdGqmHpayyMjiEhcKoVE.png", // Alipay
            "https://gw.alipayobjects.com/zos/rmsportal/zOsKZmFRdUtvpqCImOVY.png", // Angular
            "https://gw.alipayobjects.com/zos/rmsportal/dURIMkkrRFpPgTuzkwnB.png", // Ant Design
            "https://gw.alipayobjects.com/zos/rmsportal/sfjbOqnsXXJgNCjCzDBL.png", // Ant Design Pro
            "https://gw.alipayobjects.com/zos/rmsportal/siCrBXXhmvTQGWPNLBow.png", // Bootstrap
            "https://gw.alipayobjects.com/zos/rmsportal/kZzEzemZyKLKFsojXItE.png", // React
            "https://gw.alipayobjects.com/zos/rmsportal/ComBAopevLwENQdKWiIn.png", // Vue
            "https://gw.alipayobjects.com/zos/rmsportal/nxkuOJlFJuAUhzlMTCEe.png", // Webpack
    };
    String[] avatars2 = {
            "https://gw.alipayobjects.com/zos/rmsportal/BiazfanxmamNRoxxVxka.png",
            "https://gw.alipayobjects.com/zos/rmsportal/cnrhVkzwxjPwAaCfPbdc.png",
            "https://gw.alipayobjects.com/zos/rmsportal/gaOngJwsRYRaVAuXXcmB.png",
            "https://gw.alipayobjects.com/zos/rmsportal/ubnKSIfAJTxIgXOKlciN.png",
            "https://gw.alipayobjects.com/zos/rmsportal/WhxKECPNujWoWEFNdnJE.png",
            "https://gw.alipayobjects.com/zos/rmsportal/jZUIxmJycoymBprLOUbT.png",
            "https://gw.alipayobjects.com/zos/rmsportal/psOgztMplJMGpVEqfcgF.png",
            "https://gw.alipayobjects.com/zos/rmsportal/ZpBqSxLxVEXfcUNoPKrz.png",
            "https://gw.alipayobjects.com/zos/rmsportal/laiEnJdGHVOhJrUShBaJ.png",
            "https://gw.alipayobjects.com/zos/rmsportal/UrQsqscbKEpNuJcvBZBu.png",
    };
    String[] covers = {
            "https://gw.alipayobjects.com/zos/rmsportal/uMfMFlvUuceEyPpotzlq.png",
            "https://gw.alipayobjects.com/zos/rmsportal/iZBVOIhGJiAnhplqjvZW.png",
            "https://gw.alipayobjects.com/zos/rmsportal/uVZonEtjWwmUZPBQfycs.png",
            "https://gw.alipayobjects.com/zos/rmsportal/gLaIAoVWTtLbBWZNYEMg.png",
    };
    String[] desc = {
            "那是一种内在的东西， 他们到达不了，也无法触及的",
            "希望是一个好东西，也许是最好的，好东西是不会消亡的",
            "生命就像一盒巧克力，结果往往出人意料",
            "城镇中有那么多的酒馆，她却偏偏走进了我的酒馆",
            "那时候我只会想自己想要什么，从不想自己拥有什么",
    };
    String[] user = {
            "付小小",
            "曲丽丽",
            "林东东",
            "周星星",
            "吴加好",
            "朱偏右",
            "鱼酱",
            "乐哥",
            "谭小仪",
            "仲尼",
    };
    String[] status = {
            "active", "exception", "normal"
    };

    private <T> T RANDOM_ARRAY_OBJCT(T[] arr) {
        return arr[(int) (arr.length * random.nextFloat())];
    }

    @RequestMapping("/api/fake_chart_data")
    public String data() {
        return "";
    }

    @RequestMapping("/api/project/notice")
    public String data2() {
        return "";
    }

    @RequestMapping("/api/activities")
    public String data3() {
        return "";
    }

    @RequestMapping("/api/rule")
    public RuleList data4() {
        return new RuleList(rules);
    }

    @RequestMapping("/api/fake_list")
    public List<FakeObject> data5(@RequestParam("count") int count) {
        List<FakeObject> fakeList = new ArrayList<>();
        for (int i = 0; i < count; i++) {

            fakeList.add(new FakeObject(
                    "fake-list-${i}",
                    user[i % 10],
                    titles[i % 8],
                    avatars[i % 8],
                    i % 2 == 0 ? covers[i % 4] : covers[3 - (i % 4)],
//             parseInt(i / 4, 10) % 2 === 0 ? covers[i % 4] =covers[3 - (i % 4)],
                    status[i % 3],
                    Math.ceil(Math.random() * 50) + 50,
                    avatars[i % 8],
                    "https://ant.design",
                    new Date(),
                    new Date(),
                    desc[i % 5],
                    "在中台产品的研发过程中，会出现不同的设计规范和实现方式，但其中往往存在很多类似的页面和组件，这些类似的组件会被抽离成一套标准规范。",
                    Math.ceil(Math.random() * 100000) + 100000,
                    Math.ceil(Math.random() * 1000) + 1000,
                    Math.ceil(Math.random() * 100) + 100,
                    Math.ceil(Math.random() * 100) + 100,
                    Math.ceil(Math.random() * 10) + 10,
                    "段落示意：蚂蚁金服设计平台 ant.design，用最小的工作量，无缝接入蚂蚁金服生态，提供跨越设计与开发的体验解决方案。蚂蚁金服设计平台 ant.design，用最小的工作量，无缝接入蚂蚁金服生态，提供跨越设计与开发的体验解决方案。",
                    new Avatar[]{
                            new Avatar("https://gw.alipayobjects.com/zos/rmsportal/ZiESqWwCXBRQoaPONSJe.png", "曲丽丽"),
                            new Avatar("https://gw.alipayobjects.com/zos/rmsportal/tBOxZPlITHqwlGjsJWaF.png", "王昭君"),
                            new Avatar("https://gw.alipayobjects.com/zos/rmsportal/sBxjgqiuHMGRkIjqlQCd.png", "董娜娜"),
                    }

            ));
        }

        return fakeList;
    }

    @RequestMapping("/api/profile/basic")
    public Object[] basicProfile() {
        return Profile.ProfileBasicData;
    }

    @RequestMapping("/api/profile/advanced")
    public Object[] advancedProfile() {
        return Profile.ProfileAdvancedData;
    }


}

@Data
@AllArgsConstructor
class Avatar {
    String avatar;
    String name;
}

@Data
@AllArgsConstructor
class RuleList {
    List<Rule> list;
}

@Data
@AllArgsConstructor
class Rule {

    int key;
    boolean disabled;
    String href;
    String avatar;
    String no;
    String title;
    String owner;
    String description;
    double callNo;
    double status;
    Date updatedAt;
    Date createdAt;
    double progress;
}

@Data
@AllArgsConstructor
class FakeObject {

    String id;
    String owner;
    String title;
    String avatar;
    String cover;
    String status;
    double percent;
    String logo;
    String href;
    Date updatedAt;
    Date createdAt;
    String subDescription;
    String description;
    double activeUser;
    double newUser;
    double star;
    double like;
    double message;
    String content;
    Avatar[] members;
}