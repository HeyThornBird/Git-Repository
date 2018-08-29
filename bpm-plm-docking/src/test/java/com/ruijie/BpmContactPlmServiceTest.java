package com.ruijie;

import com.ruijie.service.IBpmContactPlmService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class BpmContactPlmServiceTest extends ApplicationTest{

    @Autowired
    private IBpmContactPlmService bpmContactPlmService;


    @Test
    public void testGetCharterProcessInfo(){


        Assert.assertSame("ok","ok");
    }
}


