from pydantic import BaseModel
from typing import Optional

class MessageRequest(BaseModel):
    sender : str
    receiver : str
    content : str
    bot_name : Optional[str] = None
    
class MessageResponse(BaseModel):
    sender : str
    content : str