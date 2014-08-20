/*
 * Copyright 1999-2012 Alibaba Group.
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.dubbo.examples.generic;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.dubbo.examples.generic.api.IService;
import com.alibaba.dubbo.examples.generic.api.IUserService.Params;
import com.alibaba.dubbo.examples.generic.api.IUserService.User;

/**
 * GenericConsumer
 * 
 * @author chao.liuc
 */
public class GenericConsumer {

    public static void main(String[] args) throws Exception {
        String config = GenericConsumer.class.getPackage().getName().replace('.', '/') + "/generic-consumer.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(config);
        context.start();
        IService<Params, User> userservice = (IService)context.getBean("userservice");
        User user = userservice.get(new Params("a=b"));
        System.out.println(user);
        System.in.read();
    }
}
