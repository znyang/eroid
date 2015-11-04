package com.zen.android.center.sdk.model;

import static junit.framework.Assert.*;

import com.zen.android.eroid.data.ObjectMapperFactory;

import org.junit.Test;

/**
 * AppTest
 *
 * @author zeny
 * @version 2015.11.04
 */
public class AppTest {

    private static final String DATA = "    {\n" +
            "      \"version\": \"6.5.6\",\n" +
            "      \"url\": \"http://dd.myapp.com/16891/E44A4A971CFE39CCCE3DA3132AF05679.apk\",\n" +
            "      \"createdAt\": \"2015-11-04T13:31:15.699Z\",\n" +
            "      \"objectId\": \"563a08a360b21eab1c96a62a\",\n" +
            "      \"updatedAt\": \"2015-11-04T13:31:15.699Z\",\n" +
            "      \"packageName\": \"com.up591.gwy\",\n" +
            "      \"description\": \"91UP公务员行测，内含上万道行测试题及精选试卷，全面覆盖公务员考试知识点。课程按知识点划分并配备精品题目，知识点各个攻破，学习更有效率。更有详细解析，破译解题方法、分析常见错误、学习扩展知识，举一反三。91UP，秒杀行测！\",\n" +
            "      \"appName\": \"91UP公务员行测\"\n" +
            "    }";

    @Test
    public void testJson() throws Exception {
        App app = ObjectMapperFactory.getDefault().readValue(DATA, App.class);
        assertEquals(app.getAppName(), "91UP公务员行测");
        assertNotNull(app.getDescription());
        assertNotNull(app.getPackageName());
        assertNotNull(app.getUrl());
    }
}
