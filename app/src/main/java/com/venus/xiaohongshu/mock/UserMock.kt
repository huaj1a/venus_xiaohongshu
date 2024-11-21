package com.venus.xiaohongshu.mock

import com.venus.xiaohongshu.R
import kotlin.random.Random

/**
 * Description:
 *
 * @author: venus
 * @date: 2024/11/15
 */
object UserMock {
    private val nameList = listOf(
        "Alice", "李华", "Bob", "王明", "Charlie", "张伟",
        "David", "赵丽", "Emma", "刘洋", "Frank", "陈静",
        "Grace", "李娜", "Henry", "王刚", "Isabella", "杨柳",
        "Jack", "周杰", "Karen", "吴敏", "Leo", "郑涛",
        "Megan", "陈强", "Nicholas", "林琳", "Olivia", "黄勇",
        "Peter", "孙莉", "Quinn", "朱军", "Rachel", "李梅",
        "Samuel", "王红", "Tiffany", "周丽", "Uma", "赵刚",
        "Victor", "陈丽", "Wendy", "李杰", "Xavier", "王芳",
        "Yara", "张强", "Zachary", "刘梅", "Amelia", "陈涛",
        "Benjamin", "李芳", "Chloe", "王杰", "Daniel", "赵敏",
        "Evelyn", "刘刚", "Finn", "陈丽", "Georgia", "李勇",
        "Harrison", "王梅", "Ivy", "张丽", "Jacob", "刘涛"
    )
    
    private val imageList = listOf(
        R.drawable.p1,
        R.drawable.p2,
        R.drawable.p3,
        R.drawable.p4,
        R.drawable.p5,
        R.drawable.p6,
        R.drawable.p7,
        R.drawable.p8,
        R.drawable.p9,
        R.drawable.p10,
        R.drawable.p11
    )

    fun getRandomName(): String {
        return nameList[Random.nextInt(nameList.size)]
    }
    
    fun getRandomImage(): Int {
        return imageList[Random.nextInt(imageList.size)]
    }


}