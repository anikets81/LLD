# Memento Pattern - Complete Overview

## 📚 What is the Memento Pattern?

The **Memento Pattern** is a behavioral design pattern that allows you to **capture and externalize an object's internal state** so that the object can be restored to this state later, **without violating encapsulation**.

Think of it as taking a **snapshot** of an object's state at a specific point in time, storing it safely, and being able to restore that exact state later when needed.

---

## 🎯 When to Use Memento Pattern?

Use the Memento Pattern when:

- ✅ You need to **save and restore** an object's state
- ✅ You want to implement **undo/redo** functionality
- ✅ You need to implement **checkpoint/rollback** mechanisms
- ✅ Direct access to the object's internal state would **violate encapsulation**
- ✅ You need to maintain a **history** of object states

### Real-World Examples:

| Scenario | Use Case |
|----------|----------|
| **Text Editor** | Undo/Redo operations - save states before each edit |
| **Database Operations** | Transaction rollback - restore to previous committed state |
| **Game Development** | Save game states - restore player progress |
| **Payment Processing** | Payment state snapshots - rollback failed transactions |
| **Configuration Management** | Save configuration states - revert to previous settings |

---

## 🏗️ Pattern Structure

The Memento Pattern consists of **three main components**:

```
┌─────────────┐         ┌─────────────┐         ┌─────────────┐
│ Originator  │────────▶│   Memento   │◀────────│  Caretaker  │
│             │ creates │             │ stores  │             │
└─────────────┘         └─────────────┘         └─────────────┘
```

### 1. **Originator** 🎬
- **Role**: The object whose state needs to be saved and restored
- **Responsibilities**:
  - Creates a Memento containing a snapshot of its current state
  - Uses a Memento to restore its previous state
- **Key Methods**:
  - `createMemento()` - Creates and returns a Memento with current state
  - `restoreFromMemento(Memento m)` - Restores state from a Memento

### 2. **Memento** 📸
- **Role**: Stores the snapshot of the Originator's state
- **Characteristics**:
  - **Immutable** - Once created, its state cannot be changed
  - **Encapsulated** - Only the Originator can access its internal state
  - **Lightweight** - Contains only the necessary state data
- **Key Methods**:
  - Constructor to store state
  - Getter methods (typically only accessible by Originator)

### 3. **Caretaker** 🗄️
- **Role**: Manages and stores Mementos
- **Responsibilities**:
  - Stores Mementos (in a list, stack, or other data structure)
  - Never modifies or examines the contents of Mementos
  - Provides Mementos to Originator for restoration
- **Key Methods**:
  - `saveMemento(Memento m)` - Stores a Memento
  - `getMemento(int index)` - Retrieves a Memento
  - `getLastMemento()` - Gets the most recent Memento (for undo)

---

## 💡 How It Works - Step by Step

### Flow Diagram:

```
1. Originator has current state
   ┌─────────────┐
   │ Originator  │ State: A
   └─────────────┘

2. Originator creates Memento
   ┌─────────────┐    createMemento()    ┌─────────────┐
   │ Originator  │──────────────────────▶│   Memento   │
   │ State: A    │                        │ State: A    │
   └─────────────┘                        └─────────────┘

3. Caretaker stores Memento
   ┌─────────────┐    saveMemento()      ┌─────────────┐
   │  Caretaker  │◀──────────────────────│   Memento   │
   │   [Stack]   │                        │ State: A    │
   └─────────────┘                        └─────────────┘

4. Originator changes state
   ┌─────────────┐
   │ Originator  │ State: B (changed)
   └─────────────┘

5. Restore from Memento
   ┌─────────────┐    restore()          ┌─────────────┐
   │ Originator  │◀──────────────────────│   Memento   │
   │ State: B    │                        │ State: A    │
   └─────────────┘                        └─────────────┘
                    After restore:
   ┌─────────────┐
   │ Originator  │ State: A (restored)
   └─────────────┘
```

---

## 🔄 Payment Service Example

In the context of **PaymentService**, here's how Memento Pattern can be applied:

### Scenario:
A payment service needs to maintain a history of payment method configurations, allowing users to:
- Save payment method states before modifications
- Restore previous configurations if changes fail
- Implement undo functionality for payment method updates

### Implementation Concept:

```

```

---

## ✅ Key Benefits

| Benefit | Description |
|---------|-------------|
| **Encapsulation** | Originator's internal state remains private |
| **State Management** | Easy to save and restore object states |
| **Undo/Redo** | Simple implementation of undo/redo functionality |
| **Separation of Concerns** | State storage logic separated from business logic |
| **Flexibility** | Can store multiple states and restore any of them |

---

## ⚠️ Important Considerations

### Advantages:
- ✅ Preserves encapsulation boundaries
- ✅ Simplifies the Originator by removing state management logic
- ✅ Easy to add new states without modifying existing code
- ✅ Supports multiple checkpoints

### Disadvantages:
- ❌ Can be **memory-intensive** if storing many large states
- ❌ Caretaker needs to manage Memento lifecycle
- ❌ May be **overkill** for simple state saving scenarios
- ❌ Requires careful design to avoid storing unnecessary data

### Best Practices:
1. **Store only necessary data** - Don't save entire object graphs if not needed
2. **Use immutable Mementos** - Once created, Memento state should not change
3. **Limit history size** - Implement a maximum history limit to prevent memory issues
4. **Clear old states** - Remove old Mementos when no longer needed

---

## 🔍 Comparison with Similar Patterns

| Pattern | Purpose | Key Difference |
|---------|---------|----------------|
| **Memento** | Save/restore object state | State is externalized and stored separately |
| **Command** | Encapsulate requests | Focuses on actions, not state |
| **State** | Change object behavior based on state | Manages current state, not history |
| **Prototype** | Clone objects | Creates copies, not state snapshots |

---

## 📖 Summary

The **Memento Pattern** provides a clean way to:
- 📸 **Capture** object states at specific points
- 💾 **Store** these states externally
- 🔄 **Restore** previous states when needed

It's particularly useful when you need **undo/redo functionality**, **transaction rollbacks**, or **checkpoint systems** while maintaining proper **encapsulation** of your objects.

**Remember**: The pattern's power lies in its simplicity - it separates the concern of state management from the object itself, making your code more maintainable and flexible.

---

## 🎓 Quick Reference

```
Originator → Creates Memento → Caretaker stores it
Originator → Changes state
Originator ← Restores from Memento ← Caretaker provides it
```

**Three Components, One Goal: Save and Restore State!** 🎯
