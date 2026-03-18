from .athena import respond as athena_respond
from .locky import respond as locky_respond
from .pandaman import respond as pandaman_respond
from .pixel import respond as pixel_respond

bot_map = {
    "athena" : athena_respond,
    "locky" : locky_respond,
    "pandaman" : pandaman_respond,
    "pixel" : pixel_respond
}

def get_bot_response(bot_name: str, message: str) -> str : 
    bot = bot_map.get(bot_name.lower())
    if bot :
        return bot(message)
    return "Bot inconnu."