package com.scaler.lld.design.assignments.prototype;

@FunctionalInterface
public interface ClonableObject<T> {
    T cloneObject();
}