package com.internousdev.template.action;

public class LoginAction extends ActionSupport implements SessionAware{

	private String loginUserId;
	private String loginpassword;
	private String result;
	public Map<String,Object> session;
	private LoginDAO loginDAO=new LoginDAO();
	private LoginDTO loginDTO = new LoginDTO();
	private BuyItemDAO buyItemDAO=new BuyItemDAO();

	/////////////////////////////////////////////////
	public String execute(){
		result = ERROR;

		loginDTO=loginDAO.getLoginUserInfo(loginUserId,loginPassword);

		session.put("loginUser",loginDTO);

		if(((loginDTO) session.get("loginUser")).getLoginFlg()){
			result=SUCCESS;

			BuyItemDTO buyItemDTO=buyItemDAO.getBuyItemInfo();
			session.put("login_user_id", loginDTO.getLoginId());
			session.put("id",buyItemDTO.getId());
			session.put("buyItem_name", buyItemDTO.getItemName());
			session.put("buyItem_price", buyItemDTO.getItemPrice());

			return result;
		}
		}
	}

}
