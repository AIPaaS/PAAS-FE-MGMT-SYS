package com.aic.paas.sys.peer;

import java.util.List;

import com.aic.paas.frame.cross.bean.CSysModu;
import com.aic.paas.frame.cross.bean.CSysModuDrop;
import com.aic.paas.frame.cross.bean.CSysModuRes;
import com.aic.paas.frame.cross.bean.SysModu;
import com.aic.paas.frame.cross.bean.SysModuDrop;
import com.aic.paas.frame.cross.bean.SysModuRes;
import com.binary.jdbc.Page;

public interface SysModuPeer {
	
	
	
	/**
	 * 分页查询模块
	 * @param pageNum : 指定页码
	 * @param pageSize : 指定页行数
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 系统模块表[SYS_MODU]分页列表对象
	 */
	public Page<SysModu> queryModuPage(Integer pageNum, Integer pageSize, CSysModu cdt, String orders);


	/**
	 * 不分页查询模块
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 系统模块表[SYS_MODU]查询列表
	 */
	public List<SysModu> queryModuList(CSysModu cdt, String orders);


	/**
	 * 查询模块数据行数
	 * @param cdt : 条件对象
	 * @return 查询行数
	 */
	public long queryModuCount(CSysModu cdt);


	/**
	 * 跟据主键查询模块
	 * @param id : 主键ID
	 * @return 系统模块表[SYS_MODU]映射对象
	 */
	public SysModu queryModuById(Long id);
	


	
	/**
	 * 跟据主键ID更新记录
	 * @param record : 更新的系统模块表[SYS_MODU]映射对象
	 * @param id : 主键ID
	 * @return 新插入记录的主键ID列表
	 */
	public Integer updateModuById(SysModu record, Long id);


	/**
	 * 跟据条件更新记录
	 * @param record : 更新的系统模块表[SYS_MODU]映射对象
	 * @param cdt : 条件对象
	 * @return 更新记录数
	 */
	public Integer updateModuByCdt(SysModu record, CSysModu cdt);


	/**
	 * 批量更新记录(跟据记录主键ID)
	 * @param records : 更新的系统模块表[SYS_MODU]映射对象列表
	 * @return 更新记录数列表
	 */
	public int[] updateModuBatch(List<SysModu> records);


	/**
	 * 保存获更新，判断主键ID[id]是否存在, 存在则更新, 不存在则插入
	 * @param record : SysModu数据记录
	 * @return 当前记录主键[id]值
	 */
	public Long saveOrUpdateModu(SysModu record);
	
	
	
		
	/**
	 * 不分页查询模块下拉列表
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 模块代码表[SYS_MODU_DROP]查询列表
	 */
	public List<SysModuDrop> queryModuDropList(Long moduId, CSysModuDrop cdt, String orders);

	

	
	
	/**
	 * 保存或更新模块下拉列表
	 * @param record : SysModuDrop数据记录
	 * @return 当前记录主键[id]值
	 */
	public void saveOrUpdateModuDropList(Long moduId, List<SysModuDrop> records);
	
	
	
	
	
	/**
	 * 不分页查询模块下拉列表
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 模块代码表[SYS_MODU_DROP]查询列表
	 */
	public List<SysModuRes> queryModuResList(Long moduId, CSysModuRes cdt, String orders);

	

	
	
	/**
	 * 保存或更新模块下拉列表
	 * @param record : SysModuDrop数据记录
	 * @return 当前记录主键[id]值
	 */
	public void saveOrUpdateModuResList(Long moduId, List<SysModuRes> records);
	
	
	

}
