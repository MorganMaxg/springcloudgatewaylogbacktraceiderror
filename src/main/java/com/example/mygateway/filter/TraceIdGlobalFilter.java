/**
 * Aistarfish.com Inc.
 * Copyright (c) 2017-2023 All Rights Reserved.
 */
package com.example.mygateway.filter;

import org.apache.skywalking.apm.toolkit.trace.TraceContext;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

/**
 *
 * @author xiaogang.m
 * Created by on 2023-03-08 15:51
 */
@Component
@Slf4j
public class TraceIdGlobalFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        exchange.getAttributes().put("traceId", TraceContext.traceId());
        log.info("hello world, {}", TraceContext.traceId());
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return Integer.MAX_VALUE;
    }
}
