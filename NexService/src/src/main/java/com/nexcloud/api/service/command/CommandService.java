package com.nexcloud.api.service.command;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nexcloud.rdb.mapper.mysql.CommandRepository;
import com.nexcloud.util.response.Mysql;
@Service
public class CommandService{
	@Autowired private CommandRepository commandRepository;
	@Autowired private Mysql mysql;
	
	public String  getCommandList(){
		return mysql.resultToResponse(commandRepository.getCommandList());
	}
}
