package zup.orangetalents.handler;

import java.util.List;

public class ParameterErrorResponse {
	
	static class ParameterError {
		
		private String parameter;
		private String error;
		
		public ParameterError(String parameter, String error) {
			this.parameter = parameter;
			this.error = error;
		}
		
		public String getField() {
			return this.parameter;
		}
		
		public String getError() {
			return this.error;
		}
	}
	
	private List<ParameterError> errors;
	
	public ParameterErrorResponse(List<ParameterError> erros) {
		this.errors = erros;
	}
	
	public List<ParameterError> getErrors() {
		return this.errors;
	}
	
	public String getMessage() {
		return "Não foi possível realizar a requisição, os parametros a seguir estão inválidos!";
	}
}
