//package com.example.firstapplication.model.test;
//
//import com.example.firstapplication.model.BlogDetail;
//import com.example.firstapplication.model.BlogPreview;
//import com.example.firstapplication.model.CommentShow;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class TestStaticResource {
//    public static List<BlogPreview> previews=new ArrayList<>();
//    public static List<BlogDetail> details=new ArrayList<>();
//    public static List<CommentShow> comments=new ArrayList<>();
//    private static int index;
//
//    public static void initail(){
//        previews.add(new BlogPreview("1","跌到公募骂娘",
//                "2021/11/25","每到年末，公募基金争夺" +
//                "业绩排名榜进入到白热化，就是各种幺蛾子频出的时候。昨天有一只千亿" +
//                "大 牛股，盘中闪崩跌停，惹得某公募基金经理公开骂娘，实属罕见" ));
//        previews.add(new BlogPreview("2","春秋航空：三分天注定，七分靠打拼",
//                "2021/11/25","听了近期投资者电话会的录音，" +
//                "对近期春秋航空的经营有了一些新认识，与大家分享："));
//        previews.add(new BlogPreview("3","银行与超市",
//                "2021/11/25","大家晚上好。 最近未婚女子通" +
//                "过从精子银行买进高质量精子怀孕生下混血三胞胎的新闻引发热议，空姐觉得" +
//                "只要能给孩子幸福，又能满足自己一个人生的目标，这种方式未尝不可。"));
//        details.add(new BlogDetail("1","跌到公募骂娘","南" +
//                "华基金的副总经理王明德，公开在自己的社交媒体发文炮轰，说晶澳科技这家公司的" +
//                "基本面没任何利空，这样的大跌是高频量化割韭菜的典型案例。最后居然还发了个毒" +
//                "誓，高频量化不除，市场再无宁日，股灾殷鉴不远。只是不知道，今天继续大跌，他又会作何感想\n"
//                ));
//        details.add(new BlogDetail("2","春秋航空：三分天注定，七分靠打拼","1." +
//                "关于航网结构。未来春秋航空的航网结构会越来越好。目前的情况是，" +
//                "航司的飞机引进在停滞，但机场建设仍然如期推进，这就会在未来产生一个供给与需求差。2.关于机票" +
//                "价格。近三年来，随着热门航线放开机票价格上限，热门航线的票价逐步提高，这提高了航司" +
//                "的利润弹性。当然，具有提价能力的航线仅是当前热门航线，占比30%" +
//                "3.关于未来的利润弹性。其实近年7月份就是对未来利润弹性的预演。今年7月份航司的盈利能力创下了" +
//                "历史新高。未来如果完全放开，飞机供给减少，航线供给增多，旅客需求瞬间爆发，航司的提价能力展现" +
//                "，盈利空间还是很有想象力的。4.关于未来飞机引进。未来几年，其他航司的飞机引进会停滞，但春秋航空目前还有40架的飞机引进指标，" +
//                "未来十四五期间每年新增10架飞机基本可以保障，相对于其他航司，供给增长更快，" +
//                "利润弹性更大，抗风险能力更强。"
//                ));
//        details.add(new BlogDetail("3","银行与超市","最近未婚女子通过从精子银行买进高质" +
//                "量精子怀孕生下混血三胞胎的新闻引发热议，空姐觉得只要能给孩子幸福，又能满足自己一个人生的目标，这种方式" +
//                "未尝不可。不少女性都觉得这种做法非常不错，但又囊中羞涩，据说新闻上的女主人公选择了英国男性精子，50万元" +
//                "买了三管回来，这个价格还是让大多数人望而却步。\n" +
//                "\n" +
//                "话说有个出戏的小感受，为什么明明叫银行，却可以购买里面的东西？银行不是存和取的功能吗…那还不如叫精子超市" +
//                "算了哈哈哈。\n" +
//                "\n" +
//                "今天的复盘空姐准备把盘中分享的观点直接搬过来，因为回头看看，我们盘中的提示都还算蒙对了。\n" +
//                "\n" +
//                "3602应该是本周最高点。对于趋势向上的高点如何应对？可以继续安心持仓，也可以稍稍减仓，等支撑点位买回。\n" +
//                "\n" +
//                "最不可取的处理方式是大幅减仓，想要做个大差价，这样很容易卖飞的。\n" +
//                "\n" +
//                "向上趋势和向下趋势的处理方式是不同的，一种是股票重要，一种是现金重要。\n" +
//                "\n" +
//                "目前来说，就是股票更重要。\n" +
//                "\n" +
//                "连阳股从昨天全市大涨时的24只，经过今天的高开低走，成功变成了86只，这就是个股强于大盘的行情，对于这种情" +
//                "况，非常简单，安心等指数到位，并且等待连阳股再次回到50只以下，基本上，就回踩完毕了。\n" +
//                "\n" +
//                "发现没有，最近指数失真的情况非常明显，相反，借助连阳股数量反而可以确定很多东西。\n" +
//                "\n" +
//                "今天空姐分两次买入英维克，下午21日线补仓了一次。\n" +
//                "\n" +
//                "加了几手卓胜微，满仓，其他的石基信息苏奥传感等都没有操作。\n" +
//                "\n" +
//                "前面说过，卓胜微是芯片类基金的重仓股，年底会做净值，于是就加仓了。\n" +
//                "\n" +
//                "最近次新行情不错，出现了连板妖股，前面我们也说过拓新那一波不是偶然，可能有团队行情，目前看这一块风险在慢" +
//                "慢变大，但还没有股票特停，暂时安全，一般出现大哥特停，第二天突然会有冲高才会回落，大家如果感兴趣，可以按" +
//                "照这个节奏试试看。\n" +
//                "\n" +
//                "连阳股增加一只关注：华润材料。\n" +
//                "\n" +
//                "晚安" ));
//
//        comments.add(new CommentShow("基本面没坏就一直暴涨到估值市梦率甚至市幻率？这种人是怎么当上基金经理" +
//                "的？直接拿基民血汗钱抱团，雪球里那么多股友谁不会？",
//                "023","1","2021/11/25","1"));
//        comments.add(new CommentShow("拿基金几百亿的钱，换自己几千万的年终奖，真有职业道德啊！" ,
//                "012","1","2021/11/25","2"));
////        comments.add(new CommentShow("即使看好，一架飞机利润顶天3000万，到时总共150架飞机，利润45亿，给30倍pe，市值也就1350亿，股价撑死135。想象空间太低了",
////                "034","2","2021/11/25","3"));
//        comments.add(new CommentShow("电话会里感觉对增发还是抱有继续下去的态度的，之前增发不落地的预期可能要落空了",
//                "023","2","2021/11/25","4"));
//        comments.add(new CommentShow("祝安好！",
//                "097","3","2021/11/25","5"));
//
//    }
//
//    public static void publish(String tile,String summary,String content,String date,String userId){
//        BlogDetail blogDetail=new BlogDetail(String.valueOf(previews.size()),tile,content);
//        BlogPreview blogPreview=new BlogPreview(String.valueOf(previews.size()),tile,date,summary);
//        previews.add(blogPreview);
//        details.add(blogDetail);
//    }
//
//    public static void comment(String content,String userId,String blogId,String date){
//        CommentShow commentShow=new CommentShow(content,userId,blogId,date,String.valueOf(comments.size()));
//        comments.add(commentShow);
//    }
//
//    public static void deleteComment(String blogId,String commentId){
//        for (int i=0;i<comments.size();i++){
//            if(comments.get(i).getBlog_id().equals(blogId) && comments.get(i).getCommentId().equals(commentId)){
//                CommentShow commentShow=comments.remove(i);
//            }
//        }
//    }
//
//    public static void deleteBlog(String blogId){
//        for(int i=0;i<previews.size();i++){
//            if(previews.get(i).getBlogId().equals(blogId)){
//                BlogPreview blogPreview=previews.remove(i);
//                BlogDetail blogDetail=details.remove(i);
//            }
//        }
//        for(int i=0;i<comments.size();i++){
//            if(comments.get(i).getBlog_id().equals(blogId)){
//                CommentShow commentShow=comments.remove(i);
//            }
//        }
//    }
//
//    public static List<BlogPreview> getPreviews(){
//        return previews;
//    }
//
//    public static BlogDetail getDetail(int index){ return details.get(index); }
//
//    public static List<CommentShow> getComments(String blogId){
//        List<CommentShow> result=new ArrayList<>();
//        for (int i=0;i<comments.size();i++){
//            if(comments.get(i).getBlog_id().equals(blogId)){
//                result.add(comments.get(i));
//            }
//        }
//        return result;
//    }
//
//    public static int getIndex(){return index;}
//
//    public static void setIndex(int indexGiven){ index=indexGiven;}
//
//}
