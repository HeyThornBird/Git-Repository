package com.ruijie.mapper;

import com.ruijie.bean.AptyProcessInfo;
import com.ruijie.bean.ChaterProcessInfo;
import com.ruijie.bean.Params;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * @author zhangchunhui
 * @date 2018-08-27
 */
@Mapper
public interface BpmContactPlmMapper {
    /**
     * 查询ChaterProcess相关信息
     * @param params 查询条件
     * @return 查询结果
     */
    @SelectProvider(type = Provider.class, method = "getCharterProcessInfoSQL")
    List<ChaterProcessInfo> getChaterProcessInfo(Params params);

    /**
     * 从bpm中查询A，P，T，Y四个业务流程相关数据
     * @param params 查询条件
     * @return 查询结果
     */
    @SelectProvider(type = Provider.class, method = "getAptyProcessInfo")
    List<AptyProcessInfo> getAptyProcessInfo(Params params);


    class Provider {

        private static final String ZERO = "0";

        public String getCharterProcessInfoSQL(Params params) {

            String sql = "SELECT WF_DocNumber,WF_AddName_CN,WF_LastModified,classify,businessUnit,productDevCode,productModel,productDevMode FROM\n" +
                    "(SELECT \n" +
                    "    WF_OrUNID ," +
                    "    WF_DocNumber," +
                    "    WF_AddName_CN ," +
                    "    WF_LastModified ," +
                    "    extractvalue (`XmlData`,'(/Items/WFItem[@name=\\'xmgl\\'])') AS `classify`,\n" +
                    "    extractvalue (`XmlData`,'(/Items/WFItem[@name=\\'xmsssyb\\'])') AS `businessUnit` \n" +
                    "  FROM " +
                    "    bpm_archiveddata WHERE WF_CurrentNodeName != '流程废弃' AND WF_CurrentNodeName != '流程取消'";

            if(ZERO.equals(params.getFlage())){
                sql +=  "    AND WF_OrUnid = #{wf_docunid} " +
                        "    AND WF_DocNumber = #{wf_docnumber} " +
                        "    AND WF_ProcessId = #{wf_processid} ) AS B ";
            }else{
                sql +=  "    AND WF_LastModified BETWEEN #{startDate} " +
                        "    AND #{endDate}) AS B ";
            }

            sql+="LEFT JOIN  " +
                    " (SELECT " +
                    "    WF_OrUnid, " +
                    "\t  pdm_DevelopmentCode AS productDevCode,\n" +
                    "\t  pdm_ProductModel AS productModel,\n" +
                    "\t  pdm_DevelopmentMode AS productDevMode \n" +
                    "  FROM\n" +
                    "\t  pdm_information_list_cg\n" +
                    "\t  \n" +
                    "  UNION \n" +
                    "  SELECT \n" +
                    "    WF_OrUnid,\n" +
                    "\t  pdm_DevelopmentCode AS productDevCode,\n" +
                    "\t  pdm_ProductModel AS productModel,\n" +
                    "\t  pdm_DevelopmentMode AS productDevMode \n" +
                    "  FROM\n" +
                    "\t  pdm_information_list_fc\n" +
                    "  \n" +
                    "\t  ) AS P\n" +
                    " ON  B.WF_OrUnid = P.WF_OrUnid";

            return sql;
        }


        public String getAptyProcessInfo(Params params){
            String sql = "SELECT WF_DocNumber,WF_LastModified,productDevCode,productModel,lifecycle FROM " +
                    "(SELECT " +
                    "    WF_OrUNID," +
                    "    WF_DocNumber ," +
                    "    WF_LastModified " +
                    "  FROM " +
                    "    bpm_archiveddata WHERE WF_CurrentNodeName != '流程废弃' AND WF_CurrentNodeName != '流程取消'";

            if(ZERO.equals(params.getFlage())){
                sql +=  " AND WF_OrUnid = #{wf_docunid} " +
                        " AND WF_DocNumber = #{wf_docnumber} " +
                        " AND WF_ProcessId = #{wf_processid} ) AS B ";
            }else{
                sql +=  " AND WF_LastModified BETWEEN #{startDate} AND #{endDate}) AS B";
            }

            sql+=" LEFT JOIN  " +
                    "(SELECT" +
                    "    WF_OrUnid," +
                    "    pdm_DevelopmentCode AS productDevCode," +
                    "    pdm_ProductModel AS productModel," +
                    "    pdm_Lifecycle AS lifecycle"+
                    "  FROM" +
                    "    pdm_information_list_cg" +
                    "  UNION" +
                    "  SELECT" +
                    "    WF_OrUnid," +
                    "    pdm_DevelopmentCode AS productDevCode," +
                    "    pdm_ProductModel AS productModel," +
                    "    '' AS lifecycle "+
                    "  FROM" +
                    "    pdm_information_list_fc" +
                    " ) AS P" +
                    " ON  B.WF_OrUnid = P.WF_OrUnid";

            return sql;
        }
    }


}
