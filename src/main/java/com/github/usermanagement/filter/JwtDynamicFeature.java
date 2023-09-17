package com.github.usermanagement.filter;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import jakarta.annotation.security.DenyAll;
import jakarta.annotation.security.RolesAllowed;

import javax.ws.rs.container.DynamicFeature;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.FeatureContext;
import javax.ws.rs.ext.Provider;

/**
 * Created by Mahsa.Hadiyan  Date: 9/17/2023   Time: 9:38 AM
 **/
@Provider
public class JwtDynamicFeature implements DynamicFeature{

    @Override
    public void configure(ResourceInfo resourceInfo, FeatureContext featureContext) {
        AnnotatedMethod am = new AnnotatedMethod(resourceInfo.getResourceMethod());
        if (am.isAnnotationPresent(RolesAllowed.class) || am.isAnnotationPresent(DenyAll.class)) {
            configuration.register(new AccessTokenRequestFilter(this.tokenContext));
            configuration.register(new AccessTokenResponseFilter(this.tokenContext, this.properties));
        }

    }
}
