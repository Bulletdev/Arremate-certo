/*     */ package org.apache.commons.lang3.concurrent;
/*     */ 
/*     */ import java.beans.PropertyChangeListener;
/*     */ import java.beans.PropertyChangeSupport;
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
/*     */ public abstract class AbstractCircuitBreaker<T>
/*     */   implements CircuitBreaker<T>
/*     */ {
/*     */   public static final String PROPERTY_NAME = "open";
/*  37 */   protected final AtomicReference<State> state = new AtomicReference<>(State.CLOSED);
/*     */ 
/*     */ 
/*     */   
/*     */   private final PropertyChangeSupport changeSupport;
/*     */ 
/*     */ 
/*     */   
/*     */   public AbstractCircuitBreaker() {
/*  46 */     this.changeSupport = new PropertyChangeSupport(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isOpen() {
/*  54 */     return isOpen(this.state.get());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isClosed() {
/*  62 */     return !isOpen();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract boolean checkState();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract boolean incrementAndCheckState(T paramT);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() {
/*  82 */     changeState(State.CLOSED);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void open() {
/*  90 */     changeState(State.OPEN);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static boolean isOpen(State paramState) {
/* 100 */     return (paramState == State.OPEN);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void changeState(State paramState) {
/* 110 */     if (this.state.compareAndSet(paramState.oppositeState(), paramState)) {
/* 111 */       this.changeSupport.firePropertyChange("open", !isOpen(paramState), isOpen(paramState));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addChangeListener(PropertyChangeListener paramPropertyChangeListener) {
/* 123 */     this.changeSupport.addPropertyChangeListener(paramPropertyChangeListener);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeChangeListener(PropertyChangeListener paramPropertyChangeListener) {
/* 132 */     this.changeSupport.removePropertyChangeListener(paramPropertyChangeListener);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected enum State
/*     */   {
/* 142 */     CLOSED
/*     */     {
/*     */ 
/*     */       
/*     */       public State oppositeState()
/*     */       {
/* 148 */         return OPEN;
/*     */       }
/*     */     },
/*     */     
/* 152 */     OPEN
/*     */     {
/*     */ 
/*     */       
/*     */       public State oppositeState()
/*     */       {
/* 158 */         return CLOSED;
/*     */       }
/*     */     };
/*     */     
/*     */     public abstract State oppositeState();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\concurrent\AbstractCircuitBreaker.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */