package org.funjala.automation.web.common.utilities;

import org.apache.log4j.Logger;

/**
 * Created by SergioLanda on 12/19/2016.
 */
public class Log {

  private static Log instance = null;
  protected final static Logger log = Logger.getLogger(Log.class);

  private Log() {
    super();
  }

  public static Log getInstance() {
    return instance = instance == null ? new Log() : instance;
  }

  public void errorLog(String myclass, String msg) {
    log.error("Name of class: " + myclass + "Message: " + msg);
  }

  public void debug(String myclass, String msg) {
    log.debug("Name of class: " + myclass + "Message: " + msg);
  }

  public void info(String type, String typeValue, String msg) {
    log.info(type.toUpperCase() + ": " + typeValue + "." + " Message: ".toUpperCase() + msg + ".");
  }

  public void warning(String myclass, String msg) {
    log.warn("Name of class: " + myclass + " Message: " + msg);
  }
}
