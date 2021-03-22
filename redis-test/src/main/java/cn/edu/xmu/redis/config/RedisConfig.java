package cn.edu.xmu.redis.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurationSelector;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

/**
 * @author issyu 30320182200070
 * @date 2021/1/14 17:53
 */
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {

    //选择redis作为默认缓存工具

    @Bean
    public CacheManager cacheManager(
            RedisConnectionFactory redisConnectionFactory){
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.
                defaultCacheConfig().entryTtl(Duration.ofHours(1L));
        return RedisCacheManager.builder(
                RedisCacheWriter.nonLockingRedisCacheWriter(
                        redisConnectionFactory))
                .cacheDefaults(redisCacheConfiguration)
                .build();
    }

    //配置redisTemplate相关配置

    /**
     * @bean注解会生成一个bean对象,类型是返回值的类型，名称为方法名称；
     * 在该处，会生成一个名为redisTemplate的bean对象
     * @param factory
     * @return
     */
    @Bean
    public RedisTemplate<String,Object> redisTemplate(
            RedisConnectionFactory factory){
        RedisTemplate<String,Object> template = new RedisTemplate<>();
        //配置连接工厂
        template.setConnectionFactory(factory);

        //序列化和反序列化redis的value值（默认使用JDK的序列化方式）
        Jackson2JsonRedisSerializer jacksonSerial = new Jackson2JsonRedisSerializer(Object.class);

        ObjectMapper objectMapper = new ObjectMapper();
        //指定要序列化的域，field,get和set,以及修饰符范围,ANY是都有,包括private和public
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        //指定序列化输入的类型，类必须是非final修饰的,final修饰的,比如String,Integer会出异常。

        //使用activateDefaultTyping()代替objectMapper.enableDefaultTyping();
        objectMapper.activateDefaultTyping(
                LaissezFaireSubTypeValidator.instance ,
                ObjectMapper.DefaultTyping.NON_FINAL,
                JsonTypeInfo.As.WRAPPER_ARRAY);
        //此处会导致无限递归
        //jacksonSerial.serialize(objectMapper);
        jacksonSerial.setObjectMapper(objectMapper);
        //值采用json序列化
        template.setValueSerializer(jacksonSerial);
        //使用StringRedisSerializer来序列化和反序列化redis的key
        template.setKeySerializer(new StringRedisSerializer());

        //设置hash key和value序列化
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(jacksonSerial);
        template.afterPropertiesSet();

        return template;
    }

    /**
     * 对hash类型的数据操作,但是返回值是个接口？
     * @param redisTemplate
     * @return
     */
    @Bean
    public HashOperations<String,String,Object> hashOperations(
            RedisTemplate<String,Object> redisTemplate){
        return redisTemplate.opsForHash();
    }

    /**
     * 对redis字符串类型数据库操作
     */
    @Bean
    public ValueOperations<String, Object> valueOperations(RedisTemplate<String, Object> redisTemplate) {
        return redisTemplate.opsForValue();
    }

    /**
     * 对链表类型的数据操作
     */
    @Bean
    public ListOperations<String, Object> listOperations(RedisTemplate<String, Object> redisTemplate) {
        return redisTemplate.opsForList();
    }

    /**
     * 对无序集合Set操作
     */
    @Bean
    public SetOperations<String, Object> setOperations(RedisTemplate<String, Object> redisTemplate) {
        return redisTemplate.opsForSet();
    }

    /**
     * 对有序集合
     */
    @Bean
    public ZSetOperations<String, Object> zSetOperations(RedisTemplate<String, Object> redisTemplate) {
        return redisTemplate.opsForZSet();
    }
}
