from fastapi import FastAPI
from models import MessageRequest, MessageResponse
from bots import get_bot_response

from bots import athena, pixel, locky, pandaman

app = FastAPI(title="AI Service", version="1.0")

bots = {
    "athena": athena,
    "pixel": pixel,
    "locky": locky,
    "pandaman": pandaman
}

@app.post("/bots/reply", response_model=MessageResponse)
def bot_reply(req: MessageRequest):
    bot_name = req.bot_name or req.receiver.lower()
    content = get_bot_response(bot_name, req.content)
    return MessageResponse(sender=bot_name.capitalize(), content=content)