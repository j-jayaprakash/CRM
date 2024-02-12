package com.jsp.core.service;

import java.util.List;
import java.util.StringJoiner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.jsp.core.Dto.ReadRequestDto;
import com.jsp.core.util.Clauses;
import com.jsp.core.util.Predicates;
import com.jsp.core.util.Projections;

@Service
public class CoreServiceImpl implements CoreService {

	Logger logger = LoggerFactory.getLogger(CoreServiceImpl.class);

	
	
	@Override
	public String formSqlQuery(ReadRequestDto readRequestDto) {
		
		logger.info("formSqlQuery method executed");

		if (readRequestDto != null) {
			
		logger.info("read request dto is not null"); 
			StringBuilder builder = new StringBuilder();
			builder.append("select ");
			builder.append(readRequestDto.getProjections() != null && readRequestDto.getProjections().size() != 0
					? createProjections(readRequestDto.getProjections())
					: " * ");
			builder.append("from " + readRequestDto.getEntityName());
			if (readRequestDto.getFilter() != null && readRequestDto.getFilter() != null
					&& readRequestDto.getFilter().getClauses() != null
					&& readRequestDto.getFilter().getClauses().get(0).getPredicates().size() != 0)
				builder.append(" where " + createClauses(readRequestDto.getFilter().getClauses()));

			if (readRequestDto.getOrderBy() != null && readRequestDto.getProjections().size() != 0) {
				String orderByCol = readRequestDto.getProjections().get(0).getFieldName();
				builder.append(readRequestDto.getOrderBy().equals("desc") ? " order by " + orderByCol + " desc "
						: " order by " + orderByCol);
			}

			return builder.toString();

		}

		return "read request Dto is null";
	}

	@Override
	public String createClauses(List<Clauses> clauses) {
		
		logger.info("create clause method is called");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < clauses.size(); i++) {
			Clauses clause = clauses.get(i);
			for (int j = 0; j < clause.getPredicates().size(); j++) {
				Predicates predicate = clause.getPredicates().get(j);
				switch (predicate.getOperator()) {
				case "in": {
					sb.append(predicate.getDimension() + " in ");
					StringJoiner stringJoiner = predicate.getList().get(0) instanceof Integer
							? new StringJoiner(",", " (", ") ")
							: new StringJoiner("','", " ('", "') ");
					predicate.getList().forEach((each) -> {
						stringJoiner.add(each.toString());
					});
					sb.append(stringJoiner);
					break;
				}
				case "between":
					if (predicate.getRange().get(0) instanceof Integer)
						sb.append(predicate.getDimension() + " between " + predicate.getRange().get(0) + " and "
								+ predicate.getRange().get(1) + " ");
					else
						sb.append(" between '" + predicate.getRange().get(0) + "' and '" + predicate.getRange().get(1)
								+ "' ");
					break;
				case "=": {
					if (predicate.getValue() instanceof Integer)
						sb.append(" " + predicate.getDimension() + " = " + predicate.getValue() + " ");
					else
						sb.append(" " + predicate.getDimension() + " = " + "'" + predicate.getValue() + "'" + " ");
				}
				}
				if (null != clause.getType() && clause.getPredicates().size() - 1 >= i)
					sb.append(clause.getType() + " ");
			}
		}
		return sb.toString();
	}

	@Override
	public String createProjections(List<Projections> projection) {
		logger.info("create projection method is called");
		StringBuilder sb = new StringBuilder();
		StringJoiner jo = new StringJoiner(",");
		projection.forEach((each) -> {
			jo.add(each.getFieldName());
		});
		return sb.append(jo) + " ";
	}
}
