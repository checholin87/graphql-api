package me.secosme.graphql.api.service;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.coxautodev.graphql.tools.SchemaParser;
import com.google.common.collect.Lists;
import graphql.schema.GraphQLSchema;
import graphql.servlet.AbstractGraphQLHttpServlet;
import graphql.servlet.GraphQLInvocationInputFactory;
import graphql.servlet.GraphQLObjectMapper;
import graphql.servlet.GraphQLQueryInvoker;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = "/graphql")
public class GraphQLService extends AbstractGraphQLHttpServlet {

    private static final long serialVersionUID = 1L;

    @Inject
    private Instance<GraphQLResolver<?>> resolvers;

    private GraphQLQueryInvoker invoker;
    private GraphQLInvocationInputFactory input;
    private GraphQLObjectMapper mapper;

    @Override
    public void init(ServletConfig config) throws ServletException {

        /* call parent init */

        super.init(config);

        /* create the query invoker */

        invoker = GraphQLQueryInvoker.newBuilder().build();

        /* create the invocation input */

        GraphQLSchema schema = SchemaParser.newParser()
            .file("schema.graphqls")
            .resolvers(Lists.newArrayList(resolvers))
            .build()
            .makeExecutableSchema();

        input = GraphQLInvocationInputFactory.newBuilder(schema).build();

        /* create the object mapper */

        mapper = GraphQLObjectMapper.newBuilder().build();

    }

    @Override
    protected GraphQLQueryInvoker getQueryInvoker() {
        return invoker;
    }

    @Override
    protected GraphQLInvocationInputFactory getInvocationInputFactory() {
        return input;
    }

    @Override
    protected GraphQLObjectMapper getGraphQLObjectMapper() {
        return mapper;
    }

}
