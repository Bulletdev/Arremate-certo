/*     */ package ch.qos.logback.core.joran.spi;
/*     */ 
/*     */ import ch.qos.logback.core.Context;
/*     */ import ch.qos.logback.core.joran.event.InPlayListener;
/*     */ import ch.qos.logback.core.joran.event.SaxEvent;
/*     */ import ch.qos.logback.core.spi.ContextAwareBase;
/*     */ import ch.qos.logback.core.spi.PropertyContainer;
/*     */ import ch.qos.logback.core.util.OptionHelper;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Properties;
/*     */ import java.util.Stack;
/*     */ import org.xml.sax.Locator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class InterpretationContext
/*     */   extends ContextAwareBase
/*     */   implements PropertyContainer
/*     */ {
/*     */   Stack<Object> objectStack;
/*     */   Map<String, Object> objectMap;
/*     */   Map<String, String> propertiesMap;
/*     */   Interpreter joranInterpreter;
/*  47 */   final List<InPlayListener> listenerList = new ArrayList<InPlayListener>();
/*  48 */   DefaultNestedComponentRegistry defaultNestedComponentRegistry = new DefaultNestedComponentRegistry();
/*     */   
/*     */   public InterpretationContext(Context paramContext, Interpreter paramInterpreter) {
/*  51 */     this.context = paramContext;
/*  52 */     this.joranInterpreter = paramInterpreter;
/*  53 */     this.objectStack = new Stack();
/*  54 */     this.objectMap = new HashMap<String, Object>(5);
/*  55 */     this.propertiesMap = new HashMap<String, String>(5);
/*     */   }
/*     */   
/*     */   public DefaultNestedComponentRegistry getDefaultNestedComponentRegistry() {
/*  59 */     return this.defaultNestedComponentRegistry;
/*     */   }
/*     */   
/*     */   public Map<String, String> getCopyOfPropertyMap() {
/*  63 */     return new HashMap<String, String>(this.propertiesMap);
/*     */   }
/*     */   
/*     */   void setPropertiesMap(Map<String, String> paramMap) {
/*  67 */     this.propertiesMap = paramMap;
/*     */   }
/*     */   
/*     */   String updateLocationInfo(String paramString) {
/*  71 */     Locator locator = this.joranInterpreter.getLocator();
/*     */     
/*  73 */     if (locator != null) {
/*  74 */       return paramString + locator.getLineNumber() + ":" + locator.getColumnNumber();
/*     */     }
/*  76 */     return paramString;
/*     */   }
/*     */ 
/*     */   
/*     */   public Locator getLocator() {
/*  81 */     return this.joranInterpreter.getLocator();
/*     */   }
/*     */   
/*     */   public Interpreter getJoranInterpreter() {
/*  85 */     return this.joranInterpreter;
/*     */   }
/*     */   
/*     */   public Stack<Object> getObjectStack() {
/*  89 */     return this.objectStack;
/*     */   }
/*     */   
/*     */   public boolean isEmpty() {
/*  93 */     return this.objectStack.isEmpty();
/*     */   }
/*     */   
/*     */   public Object peekObject() {
/*  97 */     return this.objectStack.peek();
/*     */   }
/*     */   
/*     */   public void pushObject(Object paramObject) {
/* 101 */     this.objectStack.push(paramObject);
/*     */   }
/*     */   
/*     */   public Object popObject() {
/* 105 */     return this.objectStack.pop();
/*     */   }
/*     */   
/*     */   public Object getObject(int paramInt) {
/* 109 */     return this.objectStack.get(paramInt);
/*     */   }
/*     */   
/*     */   public Map<String, Object> getObjectMap() {
/* 113 */     return this.objectMap;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addSubstitutionProperty(String paramString1, String paramString2) {
/* 121 */     if (paramString1 == null || paramString2 == null) {
/*     */       return;
/*     */     }
/*     */     
/* 125 */     paramString2 = paramString2.trim();
/* 126 */     this.propertiesMap.put(paramString1, paramString2);
/*     */   }
/*     */   
/*     */   public void addSubstitutionProperties(Properties paramProperties) {
/* 130 */     if (paramProperties == null) {
/*     */       return;
/*     */     }
/* 133 */     for (String str1 : paramProperties.keySet()) {
/* 134 */       String str2 = str1;
/* 135 */       String str3 = paramProperties.getProperty(str2);
/* 136 */       addSubstitutionProperty(str2, str3);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getProperty(String paramString) {
/* 145 */     String str = this.propertiesMap.get(paramString);
/* 146 */     if (str != null) {
/* 147 */       return str;
/*     */     }
/* 149 */     return this.context.getProperty(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public String subst(String paramString) {
/* 154 */     if (paramString == null) {
/* 155 */       return null;
/*     */     }
/* 157 */     return OptionHelper.substVars(paramString, this, (PropertyContainer)this.context);
/*     */   }
/*     */   
/*     */   public boolean isListenerListEmpty() {
/* 161 */     return this.listenerList.isEmpty();
/*     */   }
/*     */   
/*     */   public void addInPlayListener(InPlayListener paramInPlayListener) {
/* 165 */     if (this.listenerList.contains(paramInPlayListener)) {
/* 166 */       addWarn("InPlayListener " + paramInPlayListener + " has been already registered");
/*     */     } else {
/* 168 */       this.listenerList.add(paramInPlayListener);
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean removeInPlayListener(InPlayListener paramInPlayListener) {
/* 173 */     return this.listenerList.remove(paramInPlayListener);
/*     */   }
/*     */   
/*     */   void fireInPlay(SaxEvent paramSaxEvent) {
/* 177 */     for (InPlayListener inPlayListener : this.listenerList)
/* 178 */       inPlayListener.inPlay(paramSaxEvent); 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\joran\spi\InterpretationContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */