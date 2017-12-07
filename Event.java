package com.zhn.Remax.event;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class Event
{
  private boolean cancelled;
  
  public static enum State
  {
    PRE("PRE", 0),  POST("POST", 1);
    
    private State(String string, int number) {}
  }
  
  public Event call()
  {
    this.cancelled = false;
    call(this);
    return this;
  }
  
  public boolean isCancelled()
  {
    return this.cancelled;
  }
  
  public void setCancelled(boolean cancelled)
  {
    this.cancelled = cancelled;
  }
  
  private static final void call(Event event)
  {
    ArrayHelper<Data> dataList = EventManager.get(event.getClass());
    if (dataList != null) {
      for (Data data : dataList) {
        try
        {
          data.target.invoke(data.source, new Object[] { event });
        }
        catch (IllegalAccessException e)
        {
          e.printStackTrace();
        }
        catch (InvocationTargetException e)
        {
          e.printStackTrace();
        }
      }
    }
  }
}
