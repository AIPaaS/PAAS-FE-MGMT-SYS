package com.aic.paas.sys.peer;

import java.util.List;

import com.aic.paas.frame.cross.bean.CSysCode;
import com.aic.paas.frame.cross.bean.CSysCodeDef;
import com.aic.paas.frame.cross.bean.SysCode;
import com.aic.paas.frame.cross.bean.SysCodeDef;
import com.aic.paas.sys.bean.SysCodeInfo;
import com.binary.jdbc.Page;

public interface SysCodePeer {

	
	
	
	

	/**
	 * 分页查询定义信息
	 * @param pageNum : 指定页码
	 * @param pageSize : 指定页行数
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 代码定义表[SYS_CODE_DEF]分页列表对象
	 */
	public Page<SysCodeDef> queryDefPage(Integer pageNum, Integer pageSize, CSysCodeDef cdt, String orders);
	


	/**
	 * 不分页查询定义信息
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 代码定义表[SYS_CODE_DEF]查询列表
	 */
	public List<SysCodeDef> queryDefList(CSysCodeDef cdt, String orders);
	
	
	
	/**
	 * 跟据主键查询定义信息
	 * @param id : 主键ID
	 * @return 代码定义表[SYS_CODE_DEF]映射对象
	 */
	public SysCodeDef queryDefById(Long id);
	
	
	
		
	/**
	 * 不分页查询
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 系统代码表[SYS_CODE]查询列表
	 */
	public List<SysCode> queryCodeList(CSysCode cdt, String orders);

	
	
	
	/**
	 * 不分页查询
	 * @param defId : 指定定义ID
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 系统代码表[SYS_CODE]查询列表
	 */
	public SysCodeInfo querySysCodeInfo(Long defId, CSysCode cdt, String orders);

	
	
	

	/**
	 * 保存获更新，判断主键ID[id]是否存在, 存在则更新, 不存在则插入
	 * @param record : SysCode数据记录
	 * @return 当前记录主键[id]值
	 */
	public Long saveOrUpdate(SysCodeDef def, List<SysCode> codes);
	
	
	
	
}
