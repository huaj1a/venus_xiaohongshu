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
    
    fun getRandomTitle(): String {
        return titleList[Random.nextInt(titleList.size)]
    }
    
    fun getRandomGoodsTitle(): String {
        return goodsTitleList[Random.nextInt(goodsTitleList.size)]
    }
}