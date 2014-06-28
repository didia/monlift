package me.didia.monlift.services;

import org.glassfish.jersey.server.ResourceConfig;


public class MyApplication extends ResourceConfig {
   public MyApplication() {
       packages("me.didia.monlift.services");
 }
}
