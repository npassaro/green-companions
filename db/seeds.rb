# This file should contain all the record creation needed to seed the database with its default values.
# The data can then be loaded with the rails db:seed command (or created alongside the database with db:setup).
#
# Examples:
#
#   movies = Movie.create([{ name: 'Star Wars' }, { name: 'Lord of the Rings' }])
#   Character.create(name: 'Luke', movie: movies.first)
require 'csv'

Green.create!([
  { name: "artichoke", description: "", sow_period: (3..4).to_a, grow_period: (5..8).to_a, harvest_period: (8..9).to_a },
  { name: "celtuce", description: "Sometimes called asparagus lettuce", sow_period: (2..8).to_a, grow_period: (4..8).to_a, harvest_period: (5..10).to_a },
  { name: "asparagus pea", description: "", sow_period: (11..12).to_a, grow_period: (3..6).to_a, harvest_period: (7..9).to_a },
  { name: "basil", description: "Repels Mosquitoes", sow_period: (3..7).to_a, grow_period: (4..8).to_a, harvest_period: (5..10).to_a },
  { name: "beetroot", description: "", sow_period: (2..8).to_a, grow_period: (4..10).to_a, harvest_period: (4..10).to_a },
  { name: "bittercress", description: "",  grow_period: (3..8).to_a, harvest_period: (5..11).to_a },
  { name: "black pepper", description: "", sow_period: (3..4).to_a, grow_period: (6..7).to_a, harvest_period: (8..10).to_a },
  { name: "black radish", description: "", sow_period: (3..8).to_a, grow_period: (4..8).to_a, harvest_period: (5..12).to_a },
  { name: "blue huckleberry", description: "", sow_period: (1..12).to_a, grow_period: (1..6).to_a, harvest_period: (7..9).to_a },
  { name: "borage", description: "Repels Tomato Worms", sow_period: [3,4], grow_period: [5,6], harvest_period: [6,7] },
  { name: "bramble", description: "", sow_period: (11..12).to_a, grow_period: (1..5).to_a, harvest_period: (7..10).to_a },
  { name: "broad bean", description: "", sow_period: (1..2).to_a, grow_period: (3..4).to_a, harvest_period: (6..8).to_a },
  { name: "broccoli", description: "", sow_period: (2..4).to_a, grow_period: (6..7).to_a, harvest_period: (8..9).to_a },
  { name: "brussels sprout", description: "", sow_period: (2..4).to_a, grow_period: (5..6).to_a, harvest_period: (9..12).to_a },
  { name: "bush beans", description: "", sow_period: (3..9).to_a, grow_period: (3..9).to_a, harvest_period: (4..10).to_a },
  { name: "cabbage", description: "", sow_period: (1..3).to_a, grow_period: (4..5).to_a, harvest_period: (5..6).to_a },
  { name: "cabbage lettuce", description: "", sow_period: (3..4).to_a, grow_period: (5..8).to_a, harvest_period: (5..11).to_a },
  { name: "cantaloupe", description: "Repels ", sow_period: (2..4).to_a, grow_period: (5..6).to_a, harvest_period: (9..12).to_a },
  { name: "carrots", description: "Check the seed packet for the days to maturity, and then count backward from the first frost date in your area. For example, the average first frost date in my area is October 20, and heirloom ‘Danvers 126’ carrots need 75 days of growth before harvest.", sow_period: (3..9).to_a, grow_period: (4..10).to_a, harvest_period: (5..11).to_a },
  { name: "cauliflower", description: "", sow_period: (2..3).to_a, grow_period: (4..6).to_a, harvest_period: (7..8).to_a },
  { name: "celeriac", description: "", sow_period: (2..3).to_a, grow_period: (4..5).to_a, harvest_period: (9..12).to_a },
  { name: "celery", description: "", sow_period: (2..3).to_a, grow_period: (3..4).to_a, harvest_period: (7..10).to_a },
  { name: "chard", description: "", sow_period: (3..8).to_a, grow_period: (3..11).to_a, harvest_period: (5..11).to_a },
  { name: "chicory", description: "", sow_period: (2..5).to_a, grow_period: (5..6).to_a, harvest_period: (6..10).to_a },
  { name: "chicory roots", description: "", sow_period: (4..5).to_a, grow_period: (5..6).to_a, harvest_period: (1..12).to_a },
  { name: "chinese cabbage", description: "", sow_period: (3..8).to_a, grow_period: (4..8).to_a, harvest_period: (5..10).to_a },
  { name: "chives", description: "Repels Aphids and Japanese Beetles", sow_period: (1..3).to_a, grow_period: (2..4).to_a, harvest_period: (3..5).to_a },
  { name: "corn", description: "", sow_period: (3..6).to_a, grow_period: (5..9).to_a, harvest_period: (6..10).to_a },
  { name: "corn salad", description: "", sow_period: [], grow_period: (3..9).to_a, harvest_period: (4..12).to_a },
  { name: "cos lettuce", description: "", sow_period: (1..7).to_a, grow_period: (4..8).to_a, harvest_period: (6..9).to_a },
  { name: "cucumber", description: "", sow_period: (3..4).to_a, grow_period: (5..6).to_a, harvest_period: (7..9).to_a },
  { name: "dill", description: "Dill attracts beneficial insects such as wasps and other predatory insects to your garden, and is a host plant for the caterpillar of the black swallowtail butterfly.", sow_period: (3..7).to_a, grow_period: (4..8).to_a, harvest_period: (5..9).to_a },
  { name: "eggplant", description: "", sow_period: (3..4).to_a, grow_period: (6..8).to_a, harvest_period: (9..10).to_a },
  { name: "endive", description: "", sow_period: (3..7).to_a, grow_period: (4..8).to_a, harvest_period: (7..11).to_a },
  { name: "field pea", description: "", sow_period: (2..3).to_a, grow_period: (3..6).to_a, harvest_period: (6..7).to_a },
  { name: "garden cress", description: "", sow_period: (1..12).to_a, grow_period: (3..10).to_a, harvest_period: (1..12).to_a },
  { name: "garlic", description: "", sow_period: [], grow_period: (1..12).to_a, harvest_period: (6..7).to_a },
  { name: "gherkin", description: "", sow_period: (4..5).to_a, grow_period: (5..6).to_a, harvest_period: (7..9).to_a },
  { name: "green bean", description: "", sow_period: [], grow_period: (5..6).to_a, harvest_period: (7..9).to_a },
  { name: "hamburg root parsley", description: "", sow_period: [], grow_period: (4..9).to_a, harvest_period: (10..11).to_a },
  { name: "haricots verts", description: "", sow_period: (3..4).to_a, grow_period: (5..7).to_a, harvest_period: (8..9).to_a },
  { name: "iceberg lettuce", description: "", sow_period: (3..7).to_a, grow_period: (4..8).to_a, harvest_period: (6..11).to_a },
  { name: "indian cress", description: "", sow_period: [], grow_period: (4..6).to_a, harvest_period: (7..9).to_a },
  { name: "kale", description: "", sow_period: (5..6).to_a, grow_period: (7..12).to_a, harvest_period: (1..12).to_a },
  { name: "kohlrabi", description: "", sow_period: (3..7).to_a, grow_period: (4..8).to_a, harvest_period: (6..11).to_a },
  { name: "leek summer harvest", description: "", sow_period: (1..3).to_a, grow_period: (3..7).to_a, harvest_period: (7..9).to_a },
  { name: "lettuce", description: "", sow_period: (2..8).to_a, grow_period: (4..8).to_a, harvest_period: (5..10).to_a },
  { name: "maize", description: "", sow_period: (4..5).to_a, grow_period: (5..6).to_a, harvest_period: (6..9).to_a },
  { name: "marigolds", description: "Repels Bean Beetles, Aphids, Potato Bugs, Squash Bugs, Nematodes, and Maggots", sow_period: [], grow_period: [], harvest_period: [] },
  { name: "marjoram", description: "Repels ", sow_period: [], grow_period: [], harvest_period: [] },
  { name: "melon", description: "", sow_period: (4..6).to_a, grow_period: (6..8).to_a, harvest_period: (8..10).to_a },
  { name: "mustard", description: "", sow_period: (3..8).to_a, grow_period: (3..10).to_a, harvest_period: (4..10).to_a },
  { name: "napa cabbage", description: "", sow_period: (3..7).to_a, grow_period: (4..8).to_a, harvest_period: (6..10).to_a },
  { name: "nasturtiums", description: "Repels Aphids, Potato Bugs, Squash Bugs, Striped Pumpkin Beetles, and Mexican Bean Beetles. Destroys whiteflies in greenhoues." },
  { name: "neep", description: "", sow_period: (1..12).to_a, grow_period: (3..8).to_a, harvest_period: (3..9).to_a },
  { name: "new zealand spinach", description: "", sow_period: (3..5).to_a, grow_period: (6..7).to_a, harvest_period: (6..11).to_a },
  { name: "onions", description: "Repels Many insects/pests–especially maggots", sow_period: [], grow_period: [], harvest_period: [] },
  { name: "oregano", description: "Repels Many insects/pests", sow_period: [], grow_period: [], harvest_period: [] },
  { name: "parnips", description: "Repels ", sow_period: [], grow_period: [], harvest_period: [] },
  { name: "parsley", description: "Repels ", sow_period: [], grow_period: [], harvest_period: [] },
  { name: "parsnip", description: "", sow_period: (3..4).to_a, grow_period: (4..9).to_a, harvest_period: (10..12).to_a },
  { name: "pea", description: "", sow_period: (2..3).to_a, grow_period: (4..5).to_a, harvest_period: (6..7).to_a },
  { name: "pearl onion", description: "", sow_period: [], grow_period: (3..5).to_a, harvest_period: (7..8).to_a },
  { name: "peppers", description: "Repels ", sow_period: (1..4).to_a, grow_period: (3..6).to_a, harvest_period: (5..8).to_a},
  { name: "pole beans", description: "", sow_period: (5..6).to_a, grow_period: (6..7).to_a, harvest_period: (7..9).to_a },
  { name: "pole haricot", description: "", sow_period: [], grow_period: (5..7).to_a, harvest_period: (8..9).to_a },
  { name: "potato", description: "", sow_period: (3..4).to_a, grow_period: (4..6).to_a, harvest_period: (7..9).to_a },
  { name: "pumpkin", description: "", sow_period: (4..5).to_a, grow_period: (5..8).to_a, harvest_period: (8..9).to_a },
  { name: "purslane", description: "", sow_period: (4..8).to_a, grow_period: (7..8).to_a, harvest_period: (7..9).to_a },
  { name: "radicchio autumn harvest", description: "", sow_period: (2..3).to_a, grow_period: (5..6).to_a, harvest_period: (9..10).to_a },
  { name: "radish", description: "", sow_period: (1..3).to_a, grow_period: (4..9).to_a, harvest_period: (4..10).to_a },
  { name: "red cabbage", description: "", sow_period: (1..3).to_a, grow_period: (4..5).to_a, harvest_period: (5..6).to_a },
  { name: "red raspberry", description: "", sow_period: [], grow_period: [], harvest_period: (7..10).to_a },
  { name: "rhubarb", description: "", sow_period: (4..5).to_a, grow_period: (9..12).to_a, harvest_period: (4..8).to_a },
  { name: "romaine lettuce", description: "", sow_period: (2..3).to_a, grow_period: (4..9).to_a, harvest_period: (4..11).to_a },
  { name: "romanesco", description: "", sow_period: (4..7).to_a, grow_period: (4..7).to_a, harvest_period: (7..11).to_a },
  { name: "rosemary", description: "Repels Bean Beetles, Cabbage Moths, and Carrot Flies", sow_period: [], grow_period: [], harvest_period: [] },
  { name: "runner bean", description: "", sow_period: [], grow_period: (5..6).to_a, harvest_period: (8..9).to_a },
  { name: "rutabagas", description: "Repels ", sow_period: [], grow_period: [], harvest_period: [] },
  { name: "sage", description: "Repels Cabbage Moths and Carrot Flies", sow_period: [], grow_period: [], harvest_period: [] },
  { name: "salsify", description: "", sow_period: [], grow_period: (4..5).to_a, harvest_period: (1..12).to_a },
  { name: "savoy cabbage", description: "", sow_period: (1..4).to_a, grow_period: (4..5).to_a, harvest_period: (5..6).to_a },
  { name: "scallion", description: "", sow_period: (2..6).to_a, grow_period: (4..7).to_a, harvest_period: (6..9).to_a },
  { name: "shallot", description: "", sow_period: [], grow_period: (3..4).to_a, harvest_period: (7..8).to_a },
  { name: "snap beans", description: "", sow_period: [], grow_period: (3..4).to_a, harvest_period: (5..9).to_a },
  { name: "snow pea", description: "", sow_period: (3..4).to_a, grow_period: (4..5).to_a, harvest_period: (6..7).to_a },
  { name: "sowing onion", description: "", sow_period: (1..3).to_a, grow_period: (4..8).to_a, harvest_period: (8..9).to_a },
  { name: "soybeans", description: "Repels ", sow_period: [], grow_period: [], harvest_period: [] },
  { name: "spinach", description: "", sow_period: (1..2).to_a, grow_period: (1..8).to_a, harvest_period: (4..11).to_a },
  { name: "strawberry", description: "", sow_period: [], grow_period: (8..9).to_a, harvest_period: (6..10).to_a },
  { name: "string bean", description: "", sow_period: [], grow_period: (3..4).to_a, harvest_period: (7..9).to_a },
  { name: "summer carrots", description: "", sow_period: (3..4).to_a, grow_period: (4..6).to_a, harvest_period: (6..9).to_a },
  { name: "summer harvest", description: "", sow_period: (3..5).to_a, grow_period: (5..7).to_a, harvest_period: (7..8).to_a },
  { name: "sunflowers", description: "Repels ", sow_period: [], grow_period: [], harvest_period: [] },
  { name: "sweet corn", description: "", sow_period: (4..5).to_a, grow_period: (6..8).to_a, harvest_period: (8..10).to_a },
  { name: "thyme", description: "Repels Cabbage Moths", sow_period: [], grow_period: [], harvest_period: [] },
  { name: "tomatoes", description: "", sow_period: (2..3).to_a, grow_period: (5..7).to_a, harvest_period: (7..10).to_a },
  { name: "topinambour", description: "", sow_period: [], grow_period: (3..4).to_a, harvest_period: (10..11).to_a },
  { name: "tree onions", description: "", sow_period: [], grow_period: (3..6).to_a, harvest_period: (6..8).to_a },
  { name: "turnip", description: "", sow_period: [], grow_period: (3..5).to_a, harvest_period: (7..10).to_a },
  { name: "turnip tops", description: "", sow_period: (1..2).to_a, grow_period: (3..5).to_a, harvest_period: (5..11).to_a },
  { name: "watercress", description: "", sow_period: [], grow_period: (3..6).to_a, harvest_period: (4..11).to_a },
  { name: "welsh onion", description: "", sow_period: (1..3).to_a, grow_period: (4..5).to_a, harvest_period: (7..10).to_a },
  { name: "wild strawberry", description: "", sow_period: (11..12).to_a, grow_period: (1..4).to_a, harvest_period: (5..7).to_a },
  { name: "winter harvest", description: "", sow_period: [], grow_period: (6..8).to_a, harvest_period: (1..4).to_a },
  { name: "winter purslane", description: "", sow_period: (7..10).to_a, grow_period: (8..10).to_a, harvest_period: (1..12).to_a },
  { name: "winterunions", description: "", sow_period: [], grow_period: (8..12).to_a, harvest_period: (5..6).to_a },
  { name: "zucchini", description: "", sow_period: (4..6).to_a, grow_period: (5..7).to_a, harvest_period: (9..11).to_a }
])

def str_split_and_trim(str)
  unless str.nil?
    str.split(",").map { |g| g.strip.downcase }
  end
end

green_table = CSV.parse(File.read(File.join(Rails.root, 'db', 'companions_list.csv')), headers: true)
csv_greens = {}
green_table.each do |row|
  row["green"]
  .split('and')
  .map do |green|
    { green.strip.downcase => {
        "name" => green.strip.downcase,
        "good_companions" => str_split_and_trim(row["good companion"]),
        "bad_companions" => str_split_and_trim(row["bad companion"]),
        "description" => "Repels #{row["repels"]}"
      }
    }
  end
  .each do |g|
    csv_greens = csv_greens.merge(g)
  end
end

csv_greens.each do |csv_green_ary|
  csv_green = csv_green_ary[1]
  puts csv_green['name']
  green = Green.find_by(name: csv_green['name'])
  if !green.nil?
    good_companions = csv_green['good_companions'].map { |g|
      companion = Green.find_by(name: g)
      companion.becomes(GoodCompanion) unless companion.nil?
    }.compact unless csv_green['good_companions'].nil?
    bad_companions = csv_green['bad_companions'].map { |g|
      companion = Green.find_by(name: g)
      companion.becomes(BadCompanion) unless companion.nil?
    }.compact unless csv_green['bad_companions'].nil?
    green.good_companions.concat(good_companions) unless good_companions.nil?
    green.bad_companions.concat(bad_companions) unless bad_companions.nil?
  end
end
