package com.venus.xiaohongshu.ui.shop

import com.venus.xiaohongshu.mock.ImageMock
import com.venus.xiaohongshu.mock.TitleMock
import com.venus.xiaohongshu.ui.shop.bean.GoodsBean
import kotlinx.coroutines.delay
import java.util.UUID
import kotlin.random.Random

/**
 * Description:
 *
 * @author: venus
 * @date: 2024/11/19
 */
object ShopDataRepository {
    private val goodsList = mutableListOf<GoodsBean>()
    
    suspend fun getGoodsList(): MutableList<GoodsBean> {
        if (goodsList.isEmpty()) {
            repeat(200) {
                val goods = GoodsBean(
                    id = UUID.randomUUID().toString(),
                    title = TitleMock.getRandomGoodsTitle(),
                    image = ImageMock.getRandomGoods(),
                    price = Random.nextDouble(0.0, 1000.0),
                    discount = Random.nextDouble(0.9, 1.0),
                    times = Random.nextInt(0, 1000),
                )
                goodsList.add(goods)
                delay(5)
            }
        } 
        return goodsList
    }
}