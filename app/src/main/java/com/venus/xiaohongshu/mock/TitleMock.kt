package com.venus.xiaohongshu.mock

import kotlin.random.Random

/**
 * Description:
 *
 * @author: venus
 * @date: 2024/11/18
 */
object TitleMock {
    private val titleList: List<String> = listOf(
    "秋风送爽迎丰收",
    "科技改变新生活",
    "运动健康每一天",
    "书香满屋心自远",
    "美食享受每一刻",
    "旅行发现新世界",
    "音乐治愈心灵伤",
    "艺术点亮生活美",
    "阅读拓展新视野",
    "摄影记录美好瞬间",
    "编程创造无限可能",
    "环保守护地球家",
    "设计创新无边界",
    "电影带你看世界",
    "健身塑形更自信",
    "园艺种出幸福花",
    "手工制作心意满满",
    "绘画描绘心中梦",
    "舞蹈跳出青春韵",
    "烘焙甜蜜每一天",
    "宠物陪伴最温馨",
    "茶道品味人生味",
    "咖啡香浓暖人心",
    "书法传承文化美",
    "诗词歌赋传千古",
    "天文探索宇宙奥",
    "地理发现自然奇",
    "金融理财更明智",
    "医疗保健身体好",
    "教育培养未来才",
    "公益传递爱与光"
    )
    
    private val goodsTitleList =  listOf(
        "小米 15", "华为 P40", "苹果 iPhone 13", "三星 Galaxy S21", "索尼 a7c2", "OPPO Reno6", "vivo X60",
        "一加 9 Pro", "联想 Yoga Tab 3", "谷歌 Pixel 5", "小米 16", "华为 Mate 40", "苹果 iPhone 14",
        "三星 Galaxy Note 20", "索尼 a9g3", "OPPO Find X3", "vivo V23", "一加 9R", "联想 Legion Y7000",
        "谷歌 Pixel 6"
    )
    
    private val hotspotTitleList = listOf(
        "余承东：发布会结束有人给我转了6万",
        "提前还房贷的人后悔了吗",
        "北京突然飘雪 专家：大力出奇迹",
        "寒潮≠冷空气？“冷知识”了解一下",
        "高以翔去世5周年 墓地摆满鲜花",
        "92岁奶奶比29不到的我气血还足",
        "以色列批准黎以停火协议",
        "谷子经济彻底火了",
        "网红道歉合集：表情话术一模一样",
        "上海浦东新区区委书记朱芝松被查",
        "#北京飘雪了#",
        "13岁学生离家失联 警方：发现遗体",
        "富商去世非婚生女继承总遗产80%",
        "城管脱衣服光膀打老人？假",
        "鹤岗暴雪破纪录 乘客雪中推公交",
        "华为所有新手机将搭载鸿蒙",
        "华住集团第三季度收入64亿元",
        "华尔街资深策略师谈美股",
        "贵州发行7年期地方债",
        "我国首座海上储气库正式采气",
        "知乎第三季度营收8.45亿元",
        "中国经济三季度增长超预期",
        "NASA发现火星表面存在液态水证据",
        "全球新冠疫苗接种人数突破80亿",
        "特斯拉Model Y降价销售引发市场关注",
        "中国科学家成功克隆出首例基因编辑猪",
        "苹果公司发布新款iPhone 15 Pro Max",
        "联合国气候变化大会达成多项共识",
        "欧洲央行宣布加息应对通胀压力",
        "北京冬奥会筹备工作进入最后阶段",
        "SpaceX成功发射首批星链互联网卫星"
    )
    
    fun getRandomTitle(): String {
        return titleList[Random.nextInt(titleList.size)]
    }
    
    fun getRandomGoodsTitle(): String {
        return goodsTitleList[Random.nextInt(goodsTitleList.size)]
    }
    
    fun getRandomHotspotTitle(): String {
        return hotspotTitleList[Random.nextInt(hotspotTitleList.size)]
    }
}