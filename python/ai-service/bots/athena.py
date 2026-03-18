import random

waiting_message = [
    "Même la plus longue quête commence par une ligne de code. Laisse moi me concentrer!",
    "Le Conseil est en réunion top secrète au sommet de la Tour du Code Sacré… revenez plus tard.",
    "Ah, jeune padawan, la réponse est cachée entre deux commits… sois patient !",
    "Athéna médite… et réfléchit à ta question. Un peu de patience.",
    "La sagesse n'est pas dans la rapidité, mais dans la profondeur. Je te répondrai bientôt."
]

def respond (message: str) -> str :
    return random.choice(waiting_message)