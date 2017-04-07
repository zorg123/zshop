<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="${nameSapce}" >
  <resultMap id="BaseResultMap" type="${beanname}" >
    <#list columns as column>
    	<result column="${column}" property="${column}" jdbcType="${types[column_index]}" />
    </#list>    
  </resultMap>
  <#assign specialWords = "#{">
  <sql id="Base_Column_List" >
    <#list columns as column>
    	${column}<#if column_index != columns?size -1>,</#if>
    </#list> 
  </sql>
  <sql id="Base_Where_Clause" >
    <where >
	    <#list columns as column>
	    	<if test="${column} != null <#if types[column_index] !='TIMESTAMP'> and ${column} != '' </#if>" >
        		and ${column} = ${specialWords}${column},jdbcType=${types[column_index]}}
     		</if>
	    </#list>      
    </where>
  </sql>
  <select id="select" resultMap="BaseResultMap" parameterType="${beanname}" >
    select    
    <include refid="Base_Column_List" />
    from ${table}
    <if test="_parameter != null" >
      <include refid="Base_Where_Clause" />
    </if>
  </select>
  
  <delete id="delete" parameterType="${beanname}" >
    delete from ${table}
    <if test="_parameter != null" >
      <include refid="Base_Where_Clause" />
    </if>
  </delete>
  
  <insert id="insert" parameterType="${beanname}" >
    insert into ${table} ( <include refid="Base_Column_List" />)
    values (<#list columns as column>	    	
        	  ${specialWords}${column},jdbcType=${types[column_index]}}<#if column_index != columns?size -1>,</#if>     		
	    </#list>)
  </insert>
  
  <update id="update" parameterType="${beanname}">
    update ${table}
    set
    <#list columns as column>
   		<if test="${column} != null <#if types[column_index] !='TIMESTAMP'> and ${column} != '' </#if>" >
      		${column} = ${specialWords}${column},jdbcType=${types[column_index]}}<#if column_index != columns?size -1>,</#if>
   		</if>
   	</#list>
    <if test="_parameter != null" >
      <include refid="Base_Where_Clause" />
    </if>
    
  </update>
</mapper>