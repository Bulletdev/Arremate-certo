/*     */ package org.apache.commons.lang3.concurrent;
/*     */ 
/*     */ import java.util.EnumMap;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import java.util.concurrent.atomic.AtomicReference;
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
/*     */ public class EventCountCircuitBreaker
/*     */   extends AbstractCircuitBreaker<Integer>
/*     */ {
/* 141 */   private static final Map<AbstractCircuitBreaker.State, StateStrategy> STRATEGY_MAP = createStrategyMap();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final AtomicReference<CheckIntervalData> checkIntervalData;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final int openingThreshold;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final long openingInterval;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final int closingThreshold;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final long closingInterval;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public EventCountCircuitBreaker(int paramInt1, long paramLong1, TimeUnit paramTimeUnit1, int paramInt2, long paramLong2, TimeUnit paramTimeUnit2) {
/* 178 */     this.checkIntervalData = new AtomicReference<>(new CheckIntervalData(0, 0L));
/* 179 */     this.openingThreshold = paramInt1;
/* 180 */     this.openingInterval = paramTimeUnit1.toNanos(paramLong1);
/* 181 */     this.closingThreshold = paramInt2;
/* 182 */     this.closingInterval = paramTimeUnit2.toNanos(paramLong2);
/*     */   }
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
/*     */   public EventCountCircuitBreaker(int paramInt1, long paramLong, TimeUnit paramTimeUnit, int paramInt2) {
/* 200 */     this(paramInt1, paramLong, paramTimeUnit, paramInt2, paramLong, paramTimeUnit);
/*     */   }
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
/*     */   public EventCountCircuitBreaker(int paramInt, long paramLong, TimeUnit paramTimeUnit) {
/* 215 */     this(paramInt, paramLong, paramTimeUnit, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getOpeningThreshold() {
/* 226 */     return this.openingThreshold;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOpeningInterval() {
/* 235 */     return this.openingInterval;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getClosingThreshold() {
/* 246 */     return this.closingThreshold;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getClosingInterval() {
/* 255 */     return this.closingInterval;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean checkState() {
/* 265 */     return performStateCheck(0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean incrementAndCheckState(Integer paramInteger) {
/* 273 */     return performStateCheck(paramInteger.intValue());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean incrementAndCheckState() {
/* 285 */     return incrementAndCheckState(Integer.valueOf(1));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void open() {
/* 296 */     super.open();
/* 297 */     this.checkIntervalData.set(new CheckIntervalData(0, now()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() {
/* 308 */     super.close();
/* 309 */     this.checkIntervalData.set(new CheckIntervalData(0, now()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean performStateCheck(int paramInt) {
/*     */     CheckIntervalData checkIntervalData1;
/*     */     CheckIntervalData checkIntervalData2;
/*     */     AbstractCircuitBreaker.State state;
/*     */     do {
/* 325 */       long l = now();
/* 326 */       state = this.state.get();
/* 327 */       checkIntervalData1 = this.checkIntervalData.get();
/* 328 */       checkIntervalData2 = nextCheckIntervalData(paramInt, checkIntervalData1, state, l);
/* 329 */     } while (!updateCheckIntervalData(checkIntervalData1, checkIntervalData2));
/*     */ 
/*     */ 
/*     */     
/* 333 */     if (stateStrategy(state).isStateTransition(this, checkIntervalData1, checkIntervalData2)) {
/* 334 */       state = state.oppositeState();
/* 335 */       changeStateAndStartNewCheckInterval(state);
/*     */     } 
/* 337 */     return !isOpen(state);
/*     */   }
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
/*     */   private boolean updateCheckIntervalData(CheckIntervalData paramCheckIntervalData1, CheckIntervalData paramCheckIntervalData2) {
/* 352 */     return (paramCheckIntervalData1 == paramCheckIntervalData2 || this.checkIntervalData
/* 353 */       .compareAndSet(paramCheckIntervalData1, paramCheckIntervalData2));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void changeStateAndStartNewCheckInterval(AbstractCircuitBreaker.State paramState) {
/* 363 */     changeState(paramState);
/* 364 */     this.checkIntervalData.set(new CheckIntervalData(0, now()));
/*     */   }
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
/*     */   private CheckIntervalData nextCheckIntervalData(int paramInt, CheckIntervalData paramCheckIntervalData, AbstractCircuitBreaker.State paramState, long paramLong) {
/*     */     CheckIntervalData checkIntervalData;
/* 381 */     if (stateStrategy(paramState).isCheckIntervalFinished(this, paramCheckIntervalData, paramLong)) {
/* 382 */       checkIntervalData = new CheckIntervalData(paramInt, paramLong);
/*     */     } else {
/* 384 */       checkIntervalData = paramCheckIntervalData.increment(paramInt);
/*     */     } 
/* 386 */     return checkIntervalData;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   long now() {
/* 396 */     return System.nanoTime();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static StateStrategy stateStrategy(AbstractCircuitBreaker.State paramState) {
/* 407 */     return STRATEGY_MAP.get(paramState);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Map<AbstractCircuitBreaker.State, StateStrategy> createStrategyMap() {
/* 417 */     EnumMap<AbstractCircuitBreaker.State, Object> enumMap = new EnumMap<>(AbstractCircuitBreaker.State.class);
/* 418 */     enumMap.put(AbstractCircuitBreaker.State.CLOSED, new StateStrategyClosed());
/* 419 */     enumMap.put(AbstractCircuitBreaker.State.OPEN, new StateStrategyOpen());
/* 420 */     return (Map)enumMap;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static class CheckIntervalData
/*     */   {
/*     */     private final int eventCount;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final long checkIntervalStart;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     CheckIntervalData(int param1Int, long param1Long) {
/* 442 */       this.eventCount = param1Int;
/* 443 */       this.checkIntervalStart = param1Long;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getEventCount() {
/* 452 */       return this.eventCount;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public long getCheckIntervalStart() {
/* 461 */       return this.checkIntervalStart;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public CheckIntervalData increment(int param1Int) {
/* 472 */       return (param1Int == 0) ? this : new CheckIntervalData(getEventCount() + param1Int, 
/* 473 */           getCheckIntervalStart());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static abstract class StateStrategy
/*     */   {
/*     */     private StateStrategy() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isCheckIntervalFinished(EventCountCircuitBreaker param1EventCountCircuitBreaker, EventCountCircuitBreaker.CheckIntervalData param1CheckIntervalData, long param1Long) {
/* 493 */       return (param1Long - param1CheckIntervalData.getCheckIntervalStart() > fetchCheckInterval(param1EventCountCircuitBreaker));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public abstract boolean isStateTransition(EventCountCircuitBreaker param1EventCountCircuitBreaker, EventCountCircuitBreaker.CheckIntervalData param1CheckIntervalData1, EventCountCircuitBreaker.CheckIntervalData param1CheckIntervalData2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected abstract long fetchCheckInterval(EventCountCircuitBreaker param1EventCountCircuitBreaker);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static class StateStrategyClosed
/*     */     extends StateStrategy
/*     */   {
/*     */     private StateStrategyClosed() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isStateTransition(EventCountCircuitBreaker param1EventCountCircuitBreaker, EventCountCircuitBreaker.CheckIntervalData param1CheckIntervalData1, EventCountCircuitBreaker.CheckIntervalData param1CheckIntervalData2) {
/* 530 */       return (param1CheckIntervalData2.getEventCount() > param1EventCountCircuitBreaker.getOpeningThreshold());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected long fetchCheckInterval(EventCountCircuitBreaker param1EventCountCircuitBreaker) {
/* 538 */       return param1EventCountCircuitBreaker.getOpeningInterval();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static class StateStrategyOpen
/*     */     extends StateStrategy
/*     */   {
/*     */     private StateStrategyOpen() {}
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isStateTransition(EventCountCircuitBreaker param1EventCountCircuitBreaker, EventCountCircuitBreaker.CheckIntervalData param1CheckIntervalData1, EventCountCircuitBreaker.CheckIntervalData param1CheckIntervalData2) {
/* 552 */       return (param1CheckIntervalData2.getCheckIntervalStart() != param1CheckIntervalData1
/* 553 */         .getCheckIntervalStart() && param1CheckIntervalData1
/* 554 */         .getEventCount() < param1EventCountCircuitBreaker.getClosingThreshold());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected long fetchCheckInterval(EventCountCircuitBreaker param1EventCountCircuitBreaker) {
/* 562 */       return param1EventCountCircuitBreaker.getClosingInterval();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\concurrent\EventCountCircuitBreaker.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */