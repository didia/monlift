package me.didia.monlift.service;

import org.glassfish.jersey.server.ResourceConfig;


public class MyApplication extends ResourceConfig {
   public MyApplication() {
       packages("me.didia.monlift.service");
 }
}
